package co.id.bcaf.controller;

import co.id.bcaf.dto.GlobalResponseEntity;
import co.id.bcaf.entity.Nasabah;
import co.id.bcaf.service.NasabahService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/nasabah")
@RequiredArgsConstructor
public class NasabahController {

    private final NasabahService nasabahService;

    @GetMapping
    public ResponseEntity<GlobalResponseEntity> getAllNasabah() {
        var result = nasabahService.getAllNasabah();
        return GlobalResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<GlobalResponseEntity> addNasabah(
            @RequestParam(value = "nama") String nama
    ) {
        var result = nasabahService.addNasabah(nama);
        return GlobalResponseEntity.ok(result);
    }

    @PostMapping("/update")
    public ResponseEntity<GlobalResponseEntity> updateNasabah(
            @RequestBody Nasabah nasabah
    ) {
        var result = nasabahService.updateNasabah(nasabah);
        return GlobalResponseEntity.ok(result);
    }

    @PostMapping("/activate")
    public ResponseEntity<GlobalResponseEntity> activateNasabah(
            @RequestParam(value = "id") Long id
    ) {
        var result = nasabahService.activateNasabah(id);
        return GlobalResponseEntity.ok(result);
    }

    @PostMapping("/deactivate")
    public ResponseEntity<GlobalResponseEntity> deActivateNasabah(
            @RequestParam(value = "id") Long id
    ) {
        var result = nasabahService.deActivateNasabah(id);
        return GlobalResponseEntity.ok(result);
    }


}
