package hu.flowacademy.gyakorlatBands.service;


import hu.flowacademy.gyakorlatBands.model.Album;
import hu.flowacademy.gyakorlatBands.model.Band;

import hu.flowacademy.gyakorlatBands.repository.BandsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BandsService {

    private final BandsRepository bandsRepository;


    public List<Band> findAll() {
        return bandsRepository.findAll();
    }

    public Band save(Band band) {
        return bandsRepository.save(band.toBuilder().albums(band.getAlbums()).build());
    }

    public Optional<Band> findOne(String id) {
        return bandsRepository.findById(id);
    }



}
