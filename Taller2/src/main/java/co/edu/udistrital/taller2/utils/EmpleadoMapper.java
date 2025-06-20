package co.edu.udistrital.taller2.utils;

import co.edu.udistrital.taller2.Models.EmpleadoModel;
import co.edu.udistrital.taller2.dtos.EmpleadoDTO;
import co.edu.udistrital.taller2.entitys.EmpleadoEntity;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoMapper {

    public EmpleadoMapper(){}

    public EmpleadoDTO toDTO(EmpleadoEntity entity) {
        if (entity == null) return null;
        return EmpleadoDTO.builder()
                .id_empleado(entity.getId_empleado())
                .correo(entity.getCorreo())
                .telofono(entity.getTelofono())
                .primer_nombre(entity.getPrimer_nombre())
                .segundo_nombre(entity.getSegundo_nombre())
                .primer_apellido(entity.getPrimer_apellido())
                .segundo_apellido(entity.getSegundo_apellido())
                .build();
    }

    public EmpleadoEntity toEntityFromModel(EmpleadoModel model) {
        if (model == null) return null;
        return EmpleadoEntity.builder()
                .correo(model.getCorreo())
                .telofono(model.getTelofono())
                .primer_nombre(model.getPrimer_nombre())
                .segundo_nombre(model.getSegundo_nombre())
                .primer_apellido(model.getPrimer_apellido())
                .segundo_apellido(model.getSegundo_apellido())
                .build();
    }

    public EmpleadoEntity toEntityFromDTO(EmpleadoDTO dto) {
        if (dto == null) return null;
        return EmpleadoEntity.builder()
                .id_empleado(dto.getId_empleado())
                .correo(dto.getCorreo())
                .telofono(dto.getTelofono())
                .primer_nombre(dto.getPrimer_nombre())
                .segundo_nombre(dto.getSegundo_nombre())
                .primer_apellido(dto.getPrimer_apellido())
                .segundo_apellido(dto.getSegundo_apellido())
                .build();
    }

    public EmpleadoModel toModel(EmpleadoEntity entity) {
        if (entity == null) return null;
        return EmpleadoModel.builder()
                .correo(entity.getCorreo())
                .telofono(entity.getTelofono())
                .primer_nombre(entity.getPrimer_nombre())
                .segundo_nombre(entity.getSegundo_nombre())
                .primer_apellido(entity.getPrimer_apellido())
                .segundo_apellido(entity.getSegundo_apellido())
                .build();
    }
}
