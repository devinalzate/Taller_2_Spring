package co.edu.udistrital.taller2.Models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoHabitacionModel {
    private Long idTipoHabitacion; 
    private String nombre;
    private int cantidad;
}
