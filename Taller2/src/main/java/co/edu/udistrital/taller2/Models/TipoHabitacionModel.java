package co.edu.udistrital.taller2.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoHabitacionModel {
    private long idHotel;
    private String nombre;
    private int cantidad;
}