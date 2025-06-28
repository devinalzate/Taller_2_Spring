package co.edu.udistrital.taller2.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "factura")
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FacturaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_factura;

    private Long valor_total;
    private String fecha_emision;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_reserva")
    private ReservaEntity fk_id_reserva;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_pago")
    private PagoEntity fk_id_pago;
}

