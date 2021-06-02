package hu.flowacademy.gyakorlatBands.controller;

import hu.flowacademy.gyakorlatBands.model.Provider;
import hu.flowacademy.gyakorlatBands.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/providers/{id}")
    public Optional<Provider> findOne(@PathVariable int id) {
        return providerservice.findOne(id);
    }

    @PostMapping("/providers")
    @ResponseStatus(HttpStatus.CREATED)
    public Provider save(@RequestBody Provider provider) {
        return providerservice.save(provider);
    }

    @PutMapping("/providers/add/{id}")
    public void addSong(@PathVariable Integer id, @RequestParam("songId") Integer songId) {
        providerservice.addSong(id, songId);
    }


}
