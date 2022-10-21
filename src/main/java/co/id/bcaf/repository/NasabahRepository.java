package co.id.bcaf.repository;

import co.id.bcaf.entity.Nasabah;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NasabahRepository extends JpaRepository<Nasabah, Long> {

    Optional<Nasabah> findById(Long id);
}
