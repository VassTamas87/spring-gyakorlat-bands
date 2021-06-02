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
public class Provider {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(mappedBy = "provider")
    @JsonIgnore
    private List<Songs> songs;


}
