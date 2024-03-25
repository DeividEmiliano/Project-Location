package Location.project.api.controller;

import Location.project.api.domain.DadosEndereco;
import Location.project.api.infra.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping("/endereco")
    public ResponseEntity<DadosEndereco> obterEndereco(@RequestParam("lat") String lat, @RequestParam("lng") String lng) {
        DadosEndereco dadosEndereco = locationService.obterEndereco(lat, lng);
        return ResponseEntity.ok(dadosEndereco);

    }
}
