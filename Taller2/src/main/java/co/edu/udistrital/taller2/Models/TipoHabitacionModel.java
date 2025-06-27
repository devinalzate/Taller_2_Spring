package co.edu.udistrital.taller2.Models;

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