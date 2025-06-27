package co.edu.udistrital.taller2.Models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HabitacionModel {
    private int numeroHabitacion;
    private long idTipoHabitacion;
    private int precioDia;
    private Boolean disponible;
    private long idHotel;
}