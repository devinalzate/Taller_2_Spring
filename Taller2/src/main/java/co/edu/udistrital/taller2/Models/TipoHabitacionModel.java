package co.edu.udistrital.taller2.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoHabitacionModel {
    private Integer idHotel;
    private String nombre;
    private Integer cantidad;
}
