package co.edu.udistrital.taller2.utils;

import co.edu.udistrital.taller2.Models.AdminGeneralModel;
import co.edu.udistrital.taller2.dtos.AdminGeneralDTO;
import co.edu.udistrital.taller2.entitys.AdminGeneralEntity;
import org.springframework.stereotype.Component;

@Component
public class AdminGeneralMapper {
    public AdminGeneralMapper() {}
    // Entity → DTO
    public static AdminGeneralDTO toDTO(AdminGeneralEntity entity) {
        if (entity == null) return null;

        return AdminGeneralDTO.builder()
                .id_administrador_general(entity.getId_administrador_general())
                .correo(entity.getCorreo())
                .telefono(entity.getTelefono())
                .primer_nombre(entity.getPrimer_nombre())
                .segundo_nombre(entity.getSegundo_nombre())
                .primer_apellido(entity.getPrimer_apellido())
                .segundo_apellido(entity.getSegundo_apellido())
                .build();
    }

    // DTO → Entity
    public static AdminGeneralEntity toEntityFromDTO(AdminGeneralEntity dto) {
        if (dto == null) return null;

        return AdminGeneralEntity.builder()
                .id_administrador_general(dto.getId_administrador_general())
                .correo(dto.getCorreo())
                .telefono(dto.getTelefono())
                .primer_nombre(dto.getPrimer_nombre())
                .segundo_nombre(dto.getSegundo_nombre())
                .primer_apellido(dto.getPrimer_apellido())
                .segundo_apellido(dto.getSegundo_apellido())
                .build();
    }

    // Model → Entity
    public static AdminGeneralEntity toEntityFromModel(AdminGeneralModel model) {
        if (model == null) return null;

        return AdminGeneralEntity.builder()
                .correo(model.getCorreo())
                .telefono(model.getTelefono())
                .primer_nombre(model.getPrimer_nombre())
                .segundo_nombre(model.getSegundo_nombre())
                .primer_apellido(model.getPrimer_apellido())
                .segundo_apellido(model.getSegundo_apellido())
                .build();
    }

    // Entity → Model
    public static AdminGeneralModel toModel(AdminGeneralEntity entity) {
        if (entity == null) return null;

        return AdminGeneralModel.builder()
                .correo(entity.getCorreo())
                .telefono(entity.getTelefono())
                .primer_nombre(entity.getPrimer_nombre())
                .segundo_nombre(entity.getSegundo_nombre())
                .primer_apellido(entity.getPrimer_apellido())
                .segundo_apellido(entity.getSegundo_apellido())
                .build();
    }
}
