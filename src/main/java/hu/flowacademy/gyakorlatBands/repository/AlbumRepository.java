package hu.flowacademy.gyakorlatBands.repository;

import hu.flowacademy.gyakorlatBands.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, String> {
}
