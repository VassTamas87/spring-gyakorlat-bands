package hu.flowacademy.gyakorlatBands.service;

import hu.flowacademy.gyakorlatBands.model.Album;
import hu.flowacademy.gyakorlatBands.model.Band;
import hu.flowacademy.gyakorlatBands.repository.AlbumRepository;
import hu.flowacademy.gyakorlatBands.repository.BandsRepository;
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
    private final BandsRepository bandsRepository;

    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    public Album save(Album album, int id) {
        Band temp = bandsRepository.findById(id).orElseThrow();
        return albumRepository.save(Album.builder().title(album.getTitle()).releaseDate(album.getReleaseDate()).band(temp).build());

    }

    public Optional<Album> findOne(int id) {
        return albumRepository.findById(id);
    }


}