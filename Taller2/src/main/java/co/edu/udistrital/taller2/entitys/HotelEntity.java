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
    private Long idHotel;

    private String nombre;
    private String ciudad;
    private String telefono;
    private String correo;
    private String direccion;
}
