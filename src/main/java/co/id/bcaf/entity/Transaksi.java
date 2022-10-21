package co.id.bcaf.entity;

import co.id.bcaf.constant.JenisTransaksi;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "transaksi")
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Date createdDate;

    @Enumerated(EnumType.STRING)
    private JenisTransaksi jenisTransaksi;

    private BigDecimal nominal;

    @ManyToOne
    @JoinColumn(name = "nasabah_id")
    private Nasabah Nasabah;
}
