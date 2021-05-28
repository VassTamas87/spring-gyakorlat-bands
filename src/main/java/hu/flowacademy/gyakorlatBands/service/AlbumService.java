package hu.flowacademy.gyakorlatBands.service;

import hu.flowacademy.gyakorlatBands.model.Album;
import hu.flowacademy.gyakorlatBands.model.Band;
import hu.flowacademy.gyakorlatBands.model.Songs;
import hu.flowacademy.gyakorlatBands.repository.AlbumRepository;
import hu.flowacademy.gyakorlatBands.repository.BandsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final BandsRepository bandsRepository;

    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    public Album save(Album album) {
        return albumRepository.save(album);
    }

    public Optional<Album> findOne(int id) {
        return albumRepository.findById(id);
    }

    public List<String> findAllAlbumsByBand(String band) {
        List<Band> temp = bandsRepository.findAll().stream().filter(el -> el.getName().equals(band)).collect(Collectors.toList());
        return temp.get(0).getAlbums().stream()
                .map(el -> el.getId() + " " + el.getTitle() + " " + el.getReleaseDate() + " " + el.getSongs()
                        .stream().map(Songs::getLength)
                        .reduce(0.0, Double::sum)).collect(Collectors.toList());
    }

    public List<String> findOneWithDetails(int id) {
        return albumRepository.findById(id).stream()
                .map(el -> el.getTitle() + (el.getSongs().stream()
                        .map(songs -> songs.getId() + " " + songs.getSongTitle() + " " + songs.getLength()))
                        .collect(Collectors.toList())).collect(Collectors.toList());
    }
}

