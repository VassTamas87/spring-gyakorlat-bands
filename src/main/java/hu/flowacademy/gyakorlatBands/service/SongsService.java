package hu.flowacademy.gyakorlatBands.service;

import hu.flowacademy.gyakorlatBands.model.Provider;
import hu.flowacademy.gyakorlatBands.model.Songs;
import hu.flowacademy.gyakorlatBands.repository.SongsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SongsService {

    private final SongsRepository songsRepository;

    public List<Songs> findAll() {
        return songsRepository.findAll();
    }

    public Songs save(Songs songs) {
        return songsRepository.save(songs);
    }

    public Optional<Songs> findOne(int id) {
        return songsRepository.findById(id);
    }

    public List<String> findOneWithDetails(int id) {
        return songsRepository.findById(id).stream()
                .map(el -> el.getSongTitle() + " " + el.getLength() + " " + el.getLicencePrice() + " " + el.getProviders()
                        .stream().map(Provider::getName).collect(Collectors.toList())).collect(Collectors.toList());
    }

}