package co.edu.udistrital.taller2.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelDTO {
    private Integer idHotel;
    private String nombre;
    private String ciudad;
    private String telefono;
    private String correo;
    private String direccion;
}
