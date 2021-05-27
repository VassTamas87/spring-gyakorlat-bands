package hu.flowacademy.gyakorlatBands.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Album {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "album_id")
    private String id;
    private String title;
    private String releaseDate;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Songs> songs;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "band_id")
    @JsonIgnore
    private Band band;
}