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
public class Songs {

    @Id
    @GeneratedValue
    @Column(name = "song_id")
    private int id;
    private String songTitle;
    private double length;
    private int licencePrice;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Album album;

    @ManyToOne
    @JoinColumn
    private Provider provider;


}