package hu.flowacademy.gyakorlatBands.controller;

import hu.flowacademy.gyakorlatBands.model.Album;
import hu.flowacademy.gyakorlatBands.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bands")
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping("/{id}/albums")
    public List<Album> findAll(){
        return albumService.findAll();
    }


    @PostMapping("/{id}/albums")
    @ResponseStatus(HttpStatus.CREATED)
    public Album save(@RequestBody Album album, @PathVariable String id) {
        return albumService.save(album ,id);
    }


}