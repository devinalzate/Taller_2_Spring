package co.edu.udistrital.taller2.utils;

import co.edu.udistrital.taller2.dtos.HotelDTO;
import co.edu.udistrital.taller2.entitys.HotelEntity;
import co.edu.udistrital.taller2.models.HotelModel;

public class HotelMapper {
    public static HotelDTO toDTO(HotelEntity entity) {
        if (entity == null) return null;
        return HotelDTO.builder()
                .idHotel(entity.getIdHotel())
                .nombre(entity.getNombre())
                .ciudad(entity.getCiudad())
                .telefono(entity.getTelefono())
                .correo(entity.getCorreo())
                .direccion(entity.getDireccion())
                .build();
    }

    public static HotelEntity toEntity(HotelModel model) {
        if (model == null) return null;
        return HotelEntity.builder()
                .nombre(model.getNombre())
                .ciudad(model.getCiudad())
                .telefono(model.getTelefono())
                .correo(model.getCorreo())
                .direccion(model.getDireccion())
                .build();
    }
}
