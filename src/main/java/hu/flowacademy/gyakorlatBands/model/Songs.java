package hu.flowacademy.gyakorlatBands.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Songs {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String songTitle;
    private double length;
    private int licencePrice;
    private String onlineProvider;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn
    private Album album;



}