package hu.flowacademy.gyakorlatBands.service;

import hu.flowacademy.gyakorlatBands.model.Album;
import hu.flowacademy.gyakorlatBands.model.Songs;
import hu.flowacademy.gyakorlatBands.repository.AlbumRepository;
import hu.flowacademy.gyakorlatBands.repository.SongsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class SongsService {

    private final SongsRepository songsRepository;
    private final AlbumRepository albumRepository;

    public List<Songs> findAll() {
        return songsRepository.findAll();
    }

    public Optional<Songs> findOne(int id) {
        return songsRepository.findById(id);
    }

    public Songs save(Songs song, int id) {
        Album temp = albumRepository.findById(id).orElseThrow();
        return songsRepository.save(Songs.builder().songTitle(song.getSongTitle()).length(song.getLength()).licencePrice(song.getLicencePrice()).album(temp).build());

    }

    public Songs update(Songs song, int id) {
        Songs temp = songsRepository.findById(id).orElseThrow();
        return songsRepository.save(song.toBuilder().id(id).provider(temp.getProvider()).album(temp.getAlbum()).build());


    }


}