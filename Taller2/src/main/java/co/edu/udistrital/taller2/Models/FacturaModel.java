package co.edu.udistrital.taller2.Models;

import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FacturaModel {
    private Long id_factura;
    @NonNull
    private String fecha_emision; // Puedes cambiar a String o LocalDate según necesidad
    @NonNull
    private Integer valor_total;
    private Long fk_id_reserva;
    private Long fk_id_pago;

}