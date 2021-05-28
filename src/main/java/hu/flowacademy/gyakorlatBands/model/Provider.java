package hu.flowacademy.gyakorlatBands.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


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
}
