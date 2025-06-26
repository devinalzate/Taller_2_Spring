package co.edu.udistrital.taller2.entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hotel")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hotel")
    private Long idHotel;

    @Column(name = "nombre", length = 30, nullable = false)
    private String nombre;

    @Column(name = "ciudad", length = 20, nullable = false)
    private String ciudad;

    @Column(name = "telefono", length = 10, nullable = false)
    private String telefono;

    @Column(name = "correo", length = 100, nullable = false)
    private String correo;

    @Column(name = "direccion", length = 200, nullable = false)
    private String direccion;
}
