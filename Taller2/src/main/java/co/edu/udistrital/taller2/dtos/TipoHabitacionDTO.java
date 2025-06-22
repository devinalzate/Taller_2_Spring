package co.edu.udistrital.taller2.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoHabitacionDTO {
    private Integer idTipoHabitacion;
    private Integer idHotel;
    private String nombre;
    private Integer cantidad;
}
