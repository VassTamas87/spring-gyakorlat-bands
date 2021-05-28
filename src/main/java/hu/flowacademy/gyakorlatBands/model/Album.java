package hu.flowacademy.gyakorlatBands.model;

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
public class Album {

    @Id
    @GeneratedValue
    @Column(name = "album_id")
    private int id;
    private String title;
    private String releaseDate;


    @OneToMany(targetEntity = Songs.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "album_id", referencedColumnName = "album_id")
    private List<Songs> songs;
}