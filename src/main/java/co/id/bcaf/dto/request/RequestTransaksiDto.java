package co.id.bcaf.dto.request;

import co.id.bcaf.constant.JenisTransaksi;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Setter
@Getter
public class RequestTransaksiDto {
    private Long id;
    private JenisTransaksi jenisTransaksi;
    private BigDecimal nominal;
}
