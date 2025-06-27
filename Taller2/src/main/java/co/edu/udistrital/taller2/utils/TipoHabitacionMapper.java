package co.edu.udistrital.taller2.utils;

import co.edu.udistrital.taller2.dtos.TipoHabitacionDTO;
import co.edu.udistrital.taller2.entitys.TipoHabitacionEntity;
import co.edu.udistrital.taller2.Models.TipoHabitacionModel;

public class TipoHabitacionMapper {
    public static TipoHabitacionDTO toDTO(TipoHabitacionEntity entity) {
        if (entity == null) return null;
        return TipoHabitacionDTO.builder()
                .idTipoHabitacion(entity.getIdTipoHabitacion())
                .nombre(entity.getNombre())
                .cantidad(entity.getCantidad())
                .build();
    }

    public static TipoHabitacionEntity toEntity(TipoHabitacionModel model) {
        if (model == null) return null;
        return TipoHabitacionEntity.builder()
                .idTipoHabitacion(model.getIdTipoHabitacion())
                .nombre(model.getNombre())
                .cantidad(model.getCantidad())
                .build();
    }

    public static void updateEntityFromModel(TipoHabitacionEntity entity, TipoHabitacionModel model) {
        entity.setNombre(model.getNombre());
        entity.setCantidad(model.getCantidad());
    }
}
