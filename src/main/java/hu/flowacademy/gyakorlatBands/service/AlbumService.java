package hu.flowacademy.gyakorlatBands.service;

import hu.flowacademy.gyakorlatBands.model.Album;
import hu.flowacademy.gyakorlatBands.model.Band;
import hu.flowacademy.gyakorlatBands.model.Songs;
import hu.flowacademy.gyakorlatBands.model.dto.AlbumDto;
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

    public Album save(Album album, int id) {
        Band temp = bandsRepository.findById(id).orElseThrow();
        return albumRepository.save(album.toBuilder().band(temp).build());
    }

    public Optional<Album> findOne(int id) {
        return albumRepository.findById(id);
    }

    public List<AlbumDto> findAllWithDetails(int id) {
        List<Album> temp = albumRepository.findByBandId(id);
        return temp.stream().map(el -> new AlbumDto().builder()
                .id(el.getId()).title(el.getTitle())
                .releaseDate(el.getReleaseDate())
                .length(el.getSongs().stream()
                        .map(Songs::getLength)
                        .reduce(0.0, Double::sum))
                .build()).collect(Collectors.toList());
    }
}