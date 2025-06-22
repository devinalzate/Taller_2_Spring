package co.edu.udistrital.taller2.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HabitacionDTO {
    private Integer idHabitacion;
    private Integer numeroHabitacion;
    private Integer idTipoHabitacion;
    private Integer precioDia;
    private Boolean disponible;
    private Integer idHotel;
}
