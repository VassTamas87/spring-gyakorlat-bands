package hu.flowacademy.gyakorlatBands.controller;


import hu.flowacademy.gyakorlatBands.model.Band;
import hu.flowacademy.gyakorlatBands.service.BandsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BandsController {

    private final BandsService bandsService;


    @GetMapping("/bands")
    public List<Band> findAll() {
        return bandsService.findAll();
    }

    @GetMapping("/bands/{id}")
    final Optional<Band> findOne(@PathVariable String id) {
        return bandsService.findOne(id);
    }

    @PostMapping("/bands")
    @ResponseStatus(HttpStatus.CREATED)
    public Band save(@RequestBody Band band) {
        return bandsService.save(band);
    }


}
