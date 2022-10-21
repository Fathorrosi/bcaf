package co.id.bcaf.repository;

import co.id.bcaf.entity.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TransaksiRepository extends JpaRepository<Transaksi, Long> {

    @Query(value = "select * from transaksi t where t.nasabah_id = cast (?1 as int)", nativeQuery = true)
    List<Transaksi> findById(String id);
}
