package hu.flowacademy.gyakorlatBands.service;

import hu.flowacademy.gyakorlatBands.model.Album;
import hu.flowacademy.gyakorlatBands.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;


    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    public Album save(Album album) {
        return albumRepository.save(album);
    }

    public Optional<Album> findOne(String id) {
        return albumRepository.findById(id);
    }

}