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
public class PagoDTO {
    private Long id_pago;
    private String fecha;
    private String metodo_pago;
    private Long pago_total;
    private Long fk_id_reserva;
}
