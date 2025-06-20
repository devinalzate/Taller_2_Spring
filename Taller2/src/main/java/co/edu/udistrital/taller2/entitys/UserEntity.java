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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_empleado", unique = true)
    private EmpleadoEntity fk_id_empleado;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_administrador_general", unique = true)
    private AdminGeneralEntity fk_id_administrador_general;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_administrador", unique = true)
    private AdminEntity fk_id_administrador;
}
