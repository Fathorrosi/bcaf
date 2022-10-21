package co.id.bcaf.service;

import co.id.bcaf.entity.Nasabah;

import java.util.List;

public interface NasabahService {
    List<Nasabah> getAllNasabah();
    Nasabah addNasabah(String nama);

    Nasabah updateNasabah(Nasabah nasabah);

    Nasabah activateNasabah(Long id);

    Nasabah deActivateNasabah(Long id);

}
