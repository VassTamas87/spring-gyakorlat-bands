package hu.flowacademy.gyakorlatBands.repository;

import hu.flowacademy.gyakorlatBands.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Integer> {
}
