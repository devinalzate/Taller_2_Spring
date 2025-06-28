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
    private Long id_habitacion;

    private int numeroHabitacion;

    @OneToOne
    @JoinColumn(name = "fk_id_tipo_habitacion", unique = true)
    private TipoHabitacionEntity tipoHabitacion;


    private int precioDia;
    private Boolean disponible;

    @ManyToOne
    @JoinColumn(name = "fk_id_hotel", unique = true)
    private HotelEntity hotel;
}
