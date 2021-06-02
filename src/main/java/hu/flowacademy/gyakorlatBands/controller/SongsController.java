package hu.flowacademy.gyakorlatBands.controller;

import hu.flowacademy.gyakorlatBands.model.Songs;
import hu.flowacademy.gyakorlatBands.service.SongsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SongsController {

    private final SongsService songsService;

    @GetMapping("/songs")
    public List<Songs> findAll() {
        return songsService.findAll();
    }

    @GetMapping("/songs/{id}")
    public Optional<Songs> findOne(@PathVariable int id) {
        return songsService.findOne(id);
    }

    @PostMapping("/songs/add/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Songs save(@RequestBody Songs song, @PathVariable int id) {
        return songsService.save(song, id);
    }

    @PutMapping("/songs/{id}")
    public Songs update(@RequestBody Songs song, @PathVariable int id) {
        return songsService.update(song, id);
    }


}