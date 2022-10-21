package co.id.bcaf.entity;

import co.id.bcaf.constant.StatusNasabah;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "nasabah")
public class Nasabah {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String nama;

    @Column(length = 50)
    private String noRekening;

    @Column(length = 100)
    private BigDecimal saldo;

    @Enumerated(EnumType.STRING)
    private StatusNasabah status;
}
