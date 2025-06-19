package co.edu.udistrital.taller2.Models;


import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel {
    @NonNull
    private String nombre_usuario;
    @NonNull
    private String contrasena;
    @NonNull
    private String rol;
    private Long fk_id_cliente;
    private Long fk_id_empleado;
    private Long fk_id_administrador_general;
    private Long fk_id_administrador;
}
