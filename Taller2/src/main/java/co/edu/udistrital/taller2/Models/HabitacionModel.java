package co.edu.udistrital.taller2.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HabitacionModel {
    private Integer numeroHabitacion;
    private Integer idTipoHabitacion;
    private Integer precioDia;
    private Boolean disponible;
    private Integer idHotel;
}
