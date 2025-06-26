package co.edu.udistrital.taller2.entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "habitacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HabitacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private Long idHabitacion;

    @Column(name = "numero_habitacion", nullable = false, unique = true)
    private Int numeroHabitacion;

    @ManyToOne
    @JoinColumn(name = "fk_id_tipo_habitacion", nullable = false)
    private TipoHabitacionEntity tipoHabitacion;

    @Column(name = "precio_dia", nullable = false)
    private Int precioDia;

    @Column(name = "disponible")
    private Boolean disponible;

    @ManyToOne
    @JoinColumn(name = "fk_id_hotel", nullable = false)
    private HotelEntity hotel;
}
