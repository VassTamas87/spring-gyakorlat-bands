package hu.flowacademy.gyakorlatBands.service;

import hu.flowacademy.gyakorlatBands.model.Provider;
import hu.flowacademy.gyakorlatBands.model.Songs;
import hu.flowacademy.gyakorlatBands.repository.ProviderRepository;
import hu.flowacademy.gyakorlatBands.repository.SongsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class ProviderService {

    private final ProviderRepository providerRepository;
    private final SongsRepository songsRepository;

    public List<Provider> findAll() {
        return providerRepository.findAll();
    }

    public Optional<Provider> findOne(Integer id) {
        return providerRepository.findById(id);
    }

    public Provider save(Provider provider) {
        return providerRepository.save(provider);
    }

    public void addSong(Integer id, Integer songId) {
        Songs temp = songsRepository.findById(songId).orElseThrow();
        Provider temp2 = providerRepository.findById(id).orElseThrow();

        songsRepository.save(temp.toBuilder().id(songId).album(temp.getAlbum()).provider(temp2).build());
    }
}