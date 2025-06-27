package co.edu.udistrital.taller2.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoHabitacionDTO {
    private Long idTipoHabitacion;
    private Long idHotel;
    private String nombre;
    private int cantidad;
}
