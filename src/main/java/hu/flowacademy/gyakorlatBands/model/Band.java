package hu.flowacademy.gyakorlatBands.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.flowacademy.gyakorlatBands.enumPackage.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Band {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "band_id")
    private String id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @OneToMany(mappedBy = "band", cascade = CascadeType.ALL)
    private List<Album> albums;

}
