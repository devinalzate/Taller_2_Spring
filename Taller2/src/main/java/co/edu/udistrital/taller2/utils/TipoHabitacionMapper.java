package co.edu.udistrital.taller2.utils;

import co.edu.udistrital.taller2.dtos.TipoHabitacionDTO;
import co.edu.udistrital.taller2.entitys.TipoHabitacionEntity;
import co.edu.udistrital.taller2.entitys.HotelEntity;
import co.edu.udistrital.taller2.models.TipoHabitacionModel;

public class TipoHabitacionMapper {
    public static TipoHabitacionDTO toDTO(TipoHabitacionEntity entity) {
        if (entity == null) return null;
        return TipoHabitacionDTO.builder()
                .idTipoHabitacion(entity.getIdTipoHabitacion())
                .idHotel(entity.getHotel() != null ? entity.getHotel().getIdHotel() : null)
                .nombre(entity.getNombre())
                .cantidad(entity.getCantidad())
                .build();
    }

    public static TipoHabitacionEntity toEntity(TipoHabitacionModel model, HotelEntity hotel) {
        if (model == null) return null;
        return TipoHabitacionEntity.builder()
                .hotel(hotel)
                .nombre(model.getNombre())
                .cantidad(model.getCantidad())
                .build();
    }
}
