package co.edu.udistrital.taller2.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelModel {
    private String nombre;
    private String ciudad;
    private String telefono;
    private String correo;
    private String direccion;
}
