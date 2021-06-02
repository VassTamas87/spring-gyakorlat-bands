package hu.flowacademy.gyakorlatBands.repository;

import hu.flowacademy.gyakorlatBands.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BandsRepository extends JpaRepository<Band, Integer> {


}
