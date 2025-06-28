package co.edu.udistrital.taller2.Models;

import lombok.*;
//
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PagoModel {

    @NonNull
    private String fecha;
    private String metodo_pago;
    private Long pago_total;
    private Long fk_id_reserva;

}