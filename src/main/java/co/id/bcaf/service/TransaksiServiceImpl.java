package co.id.bcaf.service;

import co.id.bcaf.constant.StatusCode;
import co.id.bcaf.constant.StatusNasabah;
import co.id.bcaf.dto.request.RequestTransaksiDto;
import co.id.bcaf.dto.request.RequestUpdateTransaksiDto;
import co.id.bcaf.entity.Transaksi;
import co.id.bcaf.exception.BadRequestException;
import co.id.bcaf.exception.DataNotFoundException;
import co.id.bcaf.repository.NasabahRepository;
import co.id.bcaf.repository.TransaksiRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TransaksiServiceImpl implements TransaksiService{

    private final TransaksiRepository transaksiRepository;

    private final NasabahRepository nasabahRepository;

    @Override
    public List<Transaksi> getTransaksi(Long id) {
        var listTransaksi = transaksiRepository.findById(String.valueOf(id));
        return listTransaksi;
    }

    @Override
    public Transaksi addTransaksi(RequestTransaksiDto requestTransaksiDto) {
        var nasabah = nasabahRepository.findById(requestTransaksiDto.getId());
        if(nasabah.get().getStatus() == StatusNasabah.NONACTIVE) {
            throw new BadRequestException("Nasabah tidak aktif!", StatusCode.BAD_REQUEST.getCode());
        }
        if(nasabah.get().getSaldo().equals(0)) {
            throw new BadRequestException("Saldo tidak mencukupi!", StatusCode.BAD_REQUEST.getCode());
        }
        Transaksi transaksi = new Transaksi();
        transaksi.setJenisTransaksi(requestTransaksiDto.getJenisTransaksi());
        transaksi.setNominal(requestTransaksiDto.getNominal());
        transaksi.setNasabah(nasabah.get());

        transaksiRepository.save(transaksi);

        var nasabahUpdated = nasabah.get();
        nasabahUpdated.setSaldo(nasabahUpdated.getSaldo().subtract(requestTransaksiDto.getNominal()));

        nasabahRepository.save(nasabahUpdated);

        return transaksi;
    }

    @Override
    public Transaksi updateTransaksi(RequestUpdateTransaksiDto requestUpdateTransaksiDto) {
        var transaksi = transaksiRepository.findById(requestUpdateTransaksiDto.getTransaksiId())
                .orElseThrow(() -> {
                    throw new DataNotFoundException(StatusCode.NOT_FOUND.getCode());
                });

        transaksi.setJenisTransaksi(requestUpdateTransaksiDto.getJenisTransaksi());
        transaksi.setNominal(requestUpdateTransaksiDto.getNominal());

        transaksiRepository.save(transaksi);
        return transaksi;
    }

    @Override
    public void deleteTransaksi(Long id) {
        var transaksi = transaksiRepository.findById(id)
                .orElseThrow(() -> {
                    throw new DataNotFoundException(StatusCode.NOT_FOUND.getCode());
                });

        transaksiRepository.delete(transaksi);
    }
}
