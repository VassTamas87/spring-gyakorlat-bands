package hu.flowacademy.gyakorlatBands.service;

import hu.flowacademy.gyakorlatBands.model.Provider;
import hu.flowacademy.gyakorlatBands.repository.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class ProviderService {

    private final ProviderRepository providerRepository;


    public List<Provider> findAll() {
        return providerRepository.findAll();
    }

    public Optional<Provider> findOne(Integer id) {
        return providerRepository.findById(id);
    }

    public Provider save(Provider provider) {
        return providerRepository.save(provider);
    }

}