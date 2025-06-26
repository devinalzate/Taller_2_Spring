package co.edu.udistrital.taller2.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoHabitacionDTO {
    private Int idTipoHabitacion;
    private Int idHotel;
    private String nombre;
    private Int cantidad;
}
