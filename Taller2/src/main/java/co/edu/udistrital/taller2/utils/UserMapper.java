package co.edu.udistrital.taller2.utils;

import co.edu.udistrital.taller2.Models.UserModel;
import co.edu.udistrital.taller2.dtos.UserDTO;
import co.edu.udistrital.taller2.entitys.UserEntity;

public class UserMapper {
    private UserMapper(){}
    // Entity -> DTO
    public static UserDTO toDTO(UserEntity entity) {
        if (entity == null) return null;

        UserDTO dto = new UserDTO();
        dto.setId_usuario(entity.getId_usuario());
        dto.setNombre_usuario(entity.getNombre_usuario());
        dto.setRol(entity.getRol());
        dto.setFk_id_cliente(entity.getFk_id_cliente());
        dto.setFk_id_empleado(entity.getFk_id_empleado() != null ? entity.getFk_id_empleado().getId_empleado() : null);
        dto.setFk_id_administrador_general(entity.getFk_id_administrador_general() != null ? entity.getFk_id_administrador_general().getId_administrador_general() : null);
        dto.setFk_id_administrador(entity.getFk_id_administrador() != null ? entity.getFk_id_administrador().getId_administrador() : null);
        return dto;
    }

    // DTO -> Entity (sin recuperar entidades hijas aún)
    public static UserEntity toEntityFromDTO(UserDTO dto) {
        if (dto == null) return null;

        UserEntity entity = new UserEntity();
        entity.setId_usuario(dto.getId_usuario());
        entity.setNombre_usuario(dto.getNombre_usuario());
        entity.setRol(dto.getRol());
        entity.setFk_id_cliente(dto.getFk_id_cliente());

        // Relaciones: estas se deben setear desde fuera si se tienen entidades cargadas
        return entity;
    }

    // Entity -> Model
    public static UserModel toModel(UserEntity entity) {
        if (entity == null) return null;

        UserModel model = new UserModel();
        model.setNombre_usuario(entity.getNombre_usuario());
        model.setContrasena(entity.getContrasena());
        model.setRol(entity.getRol());
        model.setFk_id_cliente(entity.getFk_id_cliente());
        model.setFk_id_empleado(entity.getFk_id_empleado() != null ? entity.getFk_id_empleado().getId_empleado() : null);
        model.setFk_id_administrador_general(entity.getFk_id_administrador_general() != null ? entity.getFk_id_administrador_general().getId_administrador_general() : null);
        model.setFk_id_administrador(entity.getFk_id_administrador() != null ? entity.getFk_id_administrador().getId_administrador() : null);
        return model;
    }

    // Model -> Entity (sin relaciones cargadas)
    public static UserEntity toEntityFromModel(UserModel model) {
        if (model == null) return null;

        UserEntity entity = new UserEntity();
        entity.setNombre_usuario(model.getNombre_usuario());
        entity.setContrasena(model.getContrasena());
        entity.setRol(model.getRol());
        entity.setFk_id_cliente(model.getFk_id_cliente());

        // Relaciones se deben cargar y setear desde el servicio con repositorio
        return entity;
    }

    // DTO -> Model
    public static UserModel toModelFromDTO(UserDTO dto) {
        if (dto == null) return null;

        UserModel model = new UserModel();
        model.setNombre_usuario(dto.getNombre_usuario());
        model.setRol(dto.getRol());
        model.setFk_id_cliente(dto.getFk_id_cliente());
        model.setFk_id_empleado(dto.getFk_id_empleado());
        model.setFk_id_administrador_general(dto.getFk_id_administrador_general());
        model.setFk_id_administrador(dto.getFk_id_administrador());
        return model;
    }

    // Model -> DTO
    public static UserDTO toDTOFromModel(UserModel model) {
        if (model == null) return null;

        UserDTO dto = new UserDTO();
        dto.setNombre_usuario(model.getNombre_usuario());
        dto.setRol(model.getRol());
        dto.setFk_id_cliente(model.getFk_id_cliente());
        dto.setFk_id_empleado(model.getFk_id_empleado());
        dto.setFk_id_administrador_general(model.getFk_id_administrador_general());
        dto.setFk_id_administrador(model.getFk_id_administrador());
        return dto;
    }
}
