package co.edu.udistrital.taller2.dtos;

import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class AdminGeneralDTO {
    private Long id_administrador_general;

    private String correo;
    private String telefono;
    private String primer_nombre;
    private String segundo_nombre;
    private String primer_apellido;
    private String segundo_apellido;
}
