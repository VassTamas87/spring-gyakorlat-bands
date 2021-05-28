package hu.flowacademy.gyakorlatBands.service;

import hu.flowacademy.gyakorlatBands.model.Provider;
import hu.flowacademy.gyakorlatBands.model.Songs;
import hu.flowacademy.gyakorlatBands.repository.AlbumRepository;
import hu.flowacademy.gyakorlatBands.repository.BandsRepository;
import hu.flowacademy.gyakorlatBands.repository.ProviderRepository;
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
public class ProviderService {

    private final ProviderRepository providerRepository;
    private final SongsRepository songsRepository;

    public List<Provider> findAll() {
        return providerRepository.findAll();
    }

    public List<String> listAllProvider() {
        return providerRepository.findAll().stream().map(Provider::getName).distinct().collect(Collectors.toList());
    }

    public Provider save(Provider provider) {
        return providerRepository.save(provider);
    }

    public Optional<Provider> findOne(int id) {
        return providerRepository.findById(id);
    }

    public List<String> listAllWithSongs(String provider) {
        return songsRepository.findAll().stream().filter(el -> el.getProviders()
                .stream().anyMatch(s -> provider.equals(s.getName())))
                .collect(Collectors.toList()).stream()
                .map(st -> st.getId() + " " + st.getSongTitle()).collect(Collectors.toList());
    }
}