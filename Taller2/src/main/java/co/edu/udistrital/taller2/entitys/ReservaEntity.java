package co.edu.udistrital.taller2.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "reserva")
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder

//
public class ReservaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reserva;

    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_final;
    private Integer cantidad_dias;
    private Boolean estado;
    private LocalDateTime fecha_reserva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_habitacion")
    private HabitacionEntity fk_id_habitacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_cliente")
    private ClienteEntity fk_id_cliente;
}