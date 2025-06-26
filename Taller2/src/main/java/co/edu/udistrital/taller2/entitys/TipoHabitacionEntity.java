package co.edu.udistrital.taller2.entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipo_habitacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoHabitacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_habitacion")
    private Long idTipoHabitacion;

    @ManyToOne
    @JoinColumn(name = "fk_id_hotel", nullable = false)
    private HotelEntity hotel;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "cantidad")
    private Int cantidad;
}
