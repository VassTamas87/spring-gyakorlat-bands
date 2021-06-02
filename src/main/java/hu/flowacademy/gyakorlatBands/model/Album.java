package hu.flowacademy.gyakorlatBands.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private int id;
    private String title;
    private String releaseDate;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Band band;

    @OneToMany(mappedBy = "album")
    private List<Songs> songs;
}