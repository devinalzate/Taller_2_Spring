package co.edu.udistrital.taller2.utils;

import co.edu.udistrital.taller2.dtos.HabitacionDTO;
import co.edu.udistrital.taller2.entitys.HabitacionEntity;
import co.edu.udistrital.taller2.entitys.HotelEntity;
import co.edu.udistrital.taller2.entitys.TipoHabitacionEntity;
import co.edu.udistrital.taller2.models.HabitacionModel;

public class HabitacionMapper {
    public static HabitacionDTO toDTO(HabitacionEntity entity) {
        if (entity == null) return null;
        return HabitacionDTO.builder()
                .idHabitacion(entity.getIdHabitacion())
                .numeroHabitacion(entity.getNumeroHabitacion())
                .idTipoHabitacion(entity.getTipoHabitacion() != null ? entity.getTipoHabitacion().getIdTipoHabitacion() : null)
                .precioDia(entity.getPrecioDia())
                .disponible(entity.getDisponible())
                .idHotel(entity.getHotel() != null ? entity.getHotel().getIdHotel() : null)
                .build();
    }

    public static HabitacionEntity toEntity(HabitacionModel model, TipoHabitacionEntity tipo, HotelEntity hotel) {
        if (model == null) return null;
        return HabitacionEntity.builder()
                .numeroHabitacion(model.getNumeroHabitacion())
                .tipoHabitacion(tipo)
                .precioDia(model.getPrecioDia())
                .disponible(model.getDisponible())
                .hotel(hotel)
                .build();
    }

    public static HabitacionEntity toEntityForUpdate(
            HabitacionModel model,
            HabitacionEntity existing,
            TipoHabitacionEntity tipo,
            HotelEntity hotel
    ) {
        existing.setNumeroHabitacion(model.getNumeroHabitacion());
        existing.setTipoHabitacion(tipo);
        existing.setPrecioDia(model.getPrecioDia());
        existing.setDisponible(model.getDisponible());
        existing.setHotel(hotel);
        return existing;
    }
}