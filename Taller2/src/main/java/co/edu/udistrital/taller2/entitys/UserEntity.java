package co.edu.udistrital.taller2.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "usuario")
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    private String nombre_usuario;
    private String contrasena;
    private String rol;
    private Long fk_id_cliente;
    @OneToOne
    @JoinColumn(name = "fk_id_empleado")
    private EmpleadoEntity fk_id_empleado;
    @OneToOne
    @JoinColumn(name = "fk_id_administrador_general")
    private AdminGeneralEntity fk_id_administrador_general;
    @OneToOne
    @JoinColumn(name = "fk_id_administrador")
    private AdminEntity fk_id_administrador;
}
