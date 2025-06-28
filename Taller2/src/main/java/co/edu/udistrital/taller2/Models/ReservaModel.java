package co.edu.udistrital.taller2.Models;

import lombok.*;
//
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservaModel {
    @NonNull
    private String fecha_inicio;
    @NonNull
    private String fecha_final;
    @NonNull
    private Integer cantidad_dias;
    @NonNull
    private Boolean estado;
    @NonNull
    private String fecha_reserva;
    private Long fk_id_habitacion;
    private Long fk_id_cliente;
}