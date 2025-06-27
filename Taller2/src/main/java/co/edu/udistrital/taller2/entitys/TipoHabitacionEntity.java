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
    private Long idTipoHabitacion;

    private String nombre;
    private int cantidad;

    @OneToOne
    @JoinColumn(name = "fk_id_habitacion", unique = true)
    private HabitacionEntity Habitacion;


}
