package co.edu.udistrital.taller2.utils;

import co.edu.udistrital.taller2.Models.AdminModel;
import co.edu.udistrital.taller2.dtos.AdminDTO;
import co.edu.udistrital.taller2.entitys.AdminEntity;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {
    public AdminMapper() {}
    // Entity → DTO
    public static AdminDTO toDTO(AdminEntity entity) {
        if (entity == null) return null;

        return AdminDTO.builder()
                .id_administrador(entity.getId_administrador())
                .correo(entity.getCorreo())
                .telefono(entity.getTelefono())
                .primer_nombre(entity.getPrimer_nombre())
                .segundo_nombre(entity.getSegundo_nombre())
                .primer_apellido(entity.getPrimer_apellido())
                .segundo_apellido(entity.getSegundo_apellido())
                .build();
    }

    // DTO → Entity
    public static AdminEntity toEntityFromDTO(AdminDTO dto) {
        if (dto == null) return null;

        return AdminEntity.builder()
                .id_administrador(dto.getId_administrador())
                .correo(dto.getCorreo())
                .telefono(dto.getTelefono())
                .primer_nombre(dto.getPrimer_nombre())
                .segundo_nombre(dto.getSegundo_nombre())
                .primer_apellido(dto.getPrimer_apellido())
                .segundo_apellido(dto.getSegundo_apellido())
                .build();
    }

    // Model → Entity
    public static AdminEntity toEntityFromModel(AdminModel model) {
        if (model == null) return null;

        return AdminEntity.builder()
                .correo(model.getCorreo())
                .telefono(model.getTelefono())
                .primer_nombre(model.getPrimer_nombre())
                .segundo_nombre(model.getSegundo_nombre())
                .primer_apellido(model.getPrimer_apellido())
                .segundo_apellido(model.getSegundo_apellido())
                .build();
    }

    // Entity → Model
    public static AdminModel toModel(AdminEntity entity) {
        if (entity == null) return null;

        return AdminModel.builder()
                .correo(entity.getCorreo())
                .telefono(entity.getTelefono())
                .primer_nombre(entity.getPrimer_nombre())
                .segundo_nombre(entity.getSegundo_nombre())
                .primer_apellido(entity.getPrimer_apellido())
                .segundo_apellido(entity.getSegundo_apellido())
                .build();
    }
}
