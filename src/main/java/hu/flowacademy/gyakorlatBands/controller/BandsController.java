package hu.flowacademy.gyakorlatBands.controller;

import hu.flowacademy.gyakorlatBands.model.Band;
import hu.flowacademy.gyakorlatBands.service.BandsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BandsController {

    private final BandsService bandsService;

    @GetMapping("/bands")
    public List<Band> findAll(){
        return bandsService.findAll();
    }

    @PostMapping("/bands")
    @ResponseStatus(HttpStatus.CREATED)
    public Band save(@RequestBody Band band){
        return bandsService.save(band);
    }








}
