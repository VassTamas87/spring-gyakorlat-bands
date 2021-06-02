package hu.flowacademy.gyakorlatBands.model;

import hu.flowacademy.gyakorlatBands.enumPackage.Genre;
import lombok.*;

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
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @OneToMany(mappedBy = "band")
    private List<Album> albums;


}
