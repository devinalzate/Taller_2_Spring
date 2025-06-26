package co.edu.udistrital.taller2.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HabitacionDTO {
    private Long idHabitacion;
    private Int numeroHabitacion;
    private Long idTipoHabitacion;
    private Int precioDia;
    private Boolean disponible;
    private Long idHotel;
}
