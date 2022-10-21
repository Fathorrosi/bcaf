package co.id.bcaf.controller;

import co.id.bcaf.dto.GlobalResponseEntity;
import co.id.bcaf.dto.request.RequestTransaksiDto;
import co.id.bcaf.dto.request.RequestUpdateTransaksiDto;
import co.id.bcaf.service.TransaksiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/transaksi")
@RequiredArgsConstructor
public class TransaksiController {

    private final TransaksiService transaksiService;

    @GetMapping
    public ResponseEntity<GlobalResponseEntity> getTransaksi(
            @RequestParam Long id
    ) {
        var result = transaksiService.getTransaksi(id);
        return GlobalResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<GlobalResponseEntity> addTransaksi(
            @RequestBody RequestTransaksiDto requestTransaksiDto
    ) {
        var result = transaksiService.addTransaksi(requestTransaksiDto);
        return GlobalResponseEntity.ok(result);
    }

    @PostMapping("/update")
    public ResponseEntity<GlobalResponseEntity> updateTransaksi(
            @RequestBody RequestUpdateTransaksiDto requestUpdateTransaksiDto
    ) {
        var result = transaksiService.updateTransaksi(requestUpdateTransaksiDto);
        return GlobalResponseEntity.ok(result);
    }

    @DeleteMapping
    public ResponseEntity<GlobalResponseEntity> deleteTransaksi(
            @RequestParam Long transactionId
    ) {
        transaksiService.deleteTransaksi(transactionId);
        return GlobalResponseEntity.ok("succcess");
    }
}
