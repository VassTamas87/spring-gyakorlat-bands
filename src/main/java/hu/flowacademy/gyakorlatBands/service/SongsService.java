package hu.flowacademy.gyakorlatBands.service;

import hu.flowacademy.gyakorlatBands.model.Songs;
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

    public List<Songs> findAll() {
        return songsRepository.findAll();
    }

    public Songs save(Songs songs) {
        return songsRepository.save(songs);
    }

    public Optional<Songs> findOne(int id) {
        return songsRepository.findById(id);
    }

}