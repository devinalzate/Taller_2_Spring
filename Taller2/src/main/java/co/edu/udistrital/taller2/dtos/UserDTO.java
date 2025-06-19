package co.edu.udistrital.taller2.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id_usuario;
    private String nombre_usuario;
    private String rol;
    private Long fk_id_cliente;
    private Long fk_id_empleado;
    private Long fk_id_administrador_general;
    private Long fk_id_administrador;
}
