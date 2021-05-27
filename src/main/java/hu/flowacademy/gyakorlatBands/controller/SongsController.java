package hu.flowacademy.gyakorlatBands.controller;

import hu.flowacademy.gyakorlatBands.model.Album;
import hu.flowacademy.gyakorlatBands.model.Songs;
import hu.flowacademy.gyakorlatBands.service.AlbumService;
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
    final Optional<Songs> findOne(@PathVariable String id) {
        return songsService.findOne(id);
    }

    @PostMapping("/songs")
    @ResponseStatus(HttpStatus.CREATED)
    public Songs save(@RequestBody Songs songs) {
        return songsService.save(songs);
    }


}