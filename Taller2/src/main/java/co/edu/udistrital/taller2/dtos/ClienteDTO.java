package co.edu.udistrital.taller2.dtos;

import lombok.*;
//
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDTO {
    private Long id_cliente;

    private String direccion;
    private Integer cedula;
    private String primer_nombre;
    private String segundo_nombre;
    private String primer_apellido;
    private String segundo_apellido;
}