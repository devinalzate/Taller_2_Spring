package co.edu.udistrital.taller2.utils;

import co.edu.udistrital.taller2.Models.HotelModel;
import co.edu.udistrital.taller2.dtos.HotelDTO;
import co.edu.udistrital.taller2.entitys.HotelEntity;

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
                .idHotel(model.getIdHotel())
                .nombre(model.getNombre())
                .ciudad(model.getCiudad())
                .telefono(model.getTelefono())
                .correo(model.getCorreo())
                .direccion(model.getDireccion())
                .build();
    }

    public static void updateEntityFromModel(HotelEntity entity, HotelModel model) {
        entity.setNombre(model.getNombre());
        entity.setCiudad(model.getCiudad());
        entity.setTelefono(model.getTelefono());
        entity.setCorreo(model.getCorreo());
        entity.setDireccion(model.getDireccion());
    }
}
