package hu.flowacademy.gyakorlatBands.model;

import hu.flowacademy.gyakorlatBands.enumPackage.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Band {

    @Id
    @GeneratedValue
    @Column(name = "band_id")
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Genre genre;


    @OneToMany(targetEntity = Album.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "band_id", referencedColumnName = "band_id")
    private List<Album> albums;

}
