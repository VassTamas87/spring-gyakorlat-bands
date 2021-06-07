package hu.flowacademy.gyakorlatBands.repository;

import hu.flowacademy.gyakorlatBands.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AlbumRepository extends JpaRepository<Album, Integer> {

    List<Album> findByBandId(int id);


}
