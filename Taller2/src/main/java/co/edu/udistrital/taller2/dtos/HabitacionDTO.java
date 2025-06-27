package co.edu.udistrital.taller2.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HabitacionDTO {
    private Long idHabitacion;
    private int numeroHabitacion;
    private Long idTipoHabitacion;
    private int precioDia;
    private Boolean disponible;
    private Long idHotel;
}
