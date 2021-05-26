package hu.flowacademy.gyakorlatBands.service;

import hu.flowacademy.gyakorlatBands.repository.BandsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BandsService {

    private final BandsRepository bandsRepository;


}
