package co.id.bcaf.service;

import co.id.bcaf.dto.request.RequestTransaksiDto;
import co.id.bcaf.dto.request.RequestUpdateTransaksiDto;
import co.id.bcaf.entity.Transaksi;

import java.util.List;

public interface TransaksiService {
    List<Transaksi> getTransaksi(Long id);
    Transaksi addTransaksi(RequestTransaksiDto requestTransaksiDto);
    Transaksi updateTransaksi(RequestUpdateTransaksiDto requestUpdateTransaksiDto);

    void deleteTransaksi(Long id);
}
