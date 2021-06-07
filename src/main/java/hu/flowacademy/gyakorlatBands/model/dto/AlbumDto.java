package hu.flowacademy.gyakorlatBands.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDto {

    private int id;
    private String title;
    private String releaseDate;
    private double length;
}