package co.edu.udistrital.taller2.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "pago")
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PagoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pago;

    private String fecha;
    private String metodo_pago;
    private Long pago_total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_reserva")
    private ReservaEntity fk_id_reserva;

}