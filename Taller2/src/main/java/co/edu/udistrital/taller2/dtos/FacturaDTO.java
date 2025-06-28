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
public class FacturaDTO {
    private Long id_factura;

    private String fecha_emision;
    private Integer valor_total;
    private Long fk_id_reserva;
    private Long fk_id_pago;
}