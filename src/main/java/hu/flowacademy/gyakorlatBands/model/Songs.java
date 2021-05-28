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
public class Songs {

    @Id
    @GeneratedValue
    @Column(name = "song_id")
    private int id;
    private String songTitle;
    private double length;
    private int licencePrice;


    @OneToMany(targetEntity = Provider.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "song_id", referencedColumnName = "song_id")
    private List<Provider> providers;


}