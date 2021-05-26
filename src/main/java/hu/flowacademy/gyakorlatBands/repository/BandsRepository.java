package hu.flowacademy.gyakorlatBands.repository;

import hu.flowacademy.gyakorlatBands.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandsRepository extends JpaRepository<Band, String> {
}
