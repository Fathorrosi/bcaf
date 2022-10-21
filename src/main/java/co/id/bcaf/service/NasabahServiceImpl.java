package co.id.bcaf.service;

import co.id.bcaf.constant.StatusCode;
import co.id.bcaf.constant.StatusNasabah;
import co.id.bcaf.entity.Nasabah;
import co.id.bcaf.exception.DataNotFoundException;
import co.id.bcaf.repository.NasabahRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Slf4j
@RequiredArgsConstructor
public class NasabahServiceImpl implements NasabahService{
    private final NasabahRepository nasabahRepository;

    @Override
    public List<Nasabah> getAllNasabah() {
        List<Nasabah> listCustomer = nasabahRepository.findAll();
        if (listCustomer.isEmpty())
            throw new DataNotFoundException("Data not found!", StatusCode.NOT_FOUND.getCode());
        return listCustomer;
    }

    @Override
    public Nasabah addNasabah(String nama) {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        Nasabah nasabah = new Nasabah();
        nasabah.setNama(nama);
        nasabah.setSaldo(BigDecimal.valueOf(0));
        nasabah.setNoRekening(String.valueOf(random.nextLong(10_000_000_000L, 100_000_000_000L)));
        nasabah.setStatus(StatusNasabah.ACTIVE);

        nasabahRepository.save(nasabah);

        return nasabah;
    }

    @Override
    public Nasabah updateNasabah(Nasabah nasabah) {
        nasabahRepository.findById(nasabah.getId())
                .orElseThrow(() -> {
            throw new DataNotFoundException(StatusCode.NOT_FOUND.getCode());
        });

        nasabahRepository.save(nasabah);

        return nasabah;
    }

    @Override
    public Nasabah activateNasabah(Long id) {
        var existingNasabah =  nasabahRepository.findById(id)
                .orElseThrow(() -> {
                    throw new DataNotFoundException(StatusCode.NOT_FOUND.getCode());
                });
        existingNasabah.setStatus(StatusNasabah.ACTIVE);
        nasabahRepository.save(existingNasabah);
        return existingNasabah;
    }

    @Override
    public Nasabah deActivateNasabah(Long id) {
        var existingNasabah =  nasabahRepository.findById(id)
                .orElseThrow(() -> {
                    throw new DataNotFoundException(StatusCode.NOT_FOUND.getCode());
                });
        existingNasabah.setStatus(StatusNasabah.NONACTIVE);
        nasabahRepository.save(existingNasabah);
        return existingNasabah;
    }

}
