package hu.flowacademy.gyakorlatBands.service;


import hu.flowacademy.gyakorlatBands.model.Band;
import hu.flowacademy.gyakorlatBands.repository.BandsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BandsService {

    private final BandsRepository bandsRepository;

    public List<Band> findAll(){
        return bandsRepository.findAll();
    }

    public Band save(Band band){
        return bandsRepository.save(band.toBuilder().build());
    }





}