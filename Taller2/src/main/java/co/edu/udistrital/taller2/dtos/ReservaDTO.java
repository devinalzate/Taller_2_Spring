package co.edu.udistrital.taller2.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
//
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ReservaDTO {
    private Long id_reserva;
    
    private String fecha_inicio;     
    private String fecha_final;       
    private Integer cantidad_dias;
    private Boolean estado;
    private String fecha_reserva;
    private Long fk_id_habitacion;
    private Long fk_id_cliente;
}
