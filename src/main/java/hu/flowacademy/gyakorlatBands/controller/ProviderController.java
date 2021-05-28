package hu.flowacademy.gyakorlatBands.controller;

import hu.flowacademy.gyakorlatBands.model.Provider;
import hu.flowacademy.gyakorlatBands.model.Songs;
import hu.flowacademy.gyakorlatBands.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProviderController {

    private final ProviderService providerservice;

    @GetMapping("/providers")
    public List<Provider> findAll() {
        return providerservice.findAll();
    }

    @GetMapping("/providers/listall")
    public List<String> listAllProviders() {
        return providerservice.listAllProvider();
    }

    @GetMapping("/providers/{id}")
    public Optional<Provider> findOne(@PathVariable int id) {
        return providerservice.findOne(id);
    }

    @PostMapping("/providers")
    @ResponseStatus(HttpStatus.CREATED)
    public Provider save(@RequestBody Provider provider) {
        return providerservice.save(provider);
    }

    @GetMapping("/providers/listallwithsongs")
    public List<String> listAllWithSongs(@RequestParam("provider") String provider) {
        return providerservice.listAllWithSongs(provider);
    }


}
