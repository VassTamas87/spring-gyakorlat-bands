package hu.flowacademy.gyakorlatBands.controller;

import hu.flowacademy.gyakorlatBands.model.Album;
import hu.flowacademy.gyakorlatBands.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping("/albums")
    public List<Album> findAll() {
        return albumService.findAll();
    }

    @GetMapping("/albums/{id}")
    public Optional<Album> findOne(@PathVariable int id) {
        return albumService.findOne(id);
    }

    @PostMapping("/albums/add/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Album save(@RequestBody Album album, @PathVariable int id) {
        return albumService.save(album, id);
    }

}