package co.edu.udistrital.taller2.utils;

import co.edu.udistrital.taller2.Models.PagoModel;
import co.edu.udistrital.taller2.dtos.PagoDTO;
import co.edu.udistrital.taller2.entitys.PagoEntity;

import java.time.format.DateTimeFormatter;

public class PagoMapper {

    private PagoMapper() {}

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    // Entity -> DTO
    public static PagoDTO toDTO(PagoEntity entity) {
        if (entity == null) return null;

        PagoDTO dto = new PagoDTO();
        dto.setId_pago(entity.getId_pago());
        dto.setFecha(entity.getFecha());
        dto.setMetodo_pago(entity.getMetodo_pago());
        dto.setPago_total(entity.getPago_total());
        dto.setFk_id_reserva(entity.getFk_id_reserva() != null ? entity.getFk_id_reserva().getId_reserva() : null);
        return dto;
    }

    // DTO -> Entity (sin recuperar entidades hijas aún)
    public static PagoEntity toEntityFromDTO(PagoDTO dto) {
        if (dto == null) return null;

        PagoEntity entity = new PagoEntity();
        entity.setId_pago(dto.getId_pago());
        entity.setFecha(dto.getFecha());
        entity.setMetodo_pago(dto.getMetodo_pago());
        entity.setPago_total(dto.getPago_total());
        // Relaciones: se deben setear desde fuera si se tienen entidades cargadas
        return entity;
    }

    // Entity -> Model
    public static PagoModel toModel(PagoEntity entity) {
        if (entity == null) return null;

        PagoModel model = new PagoModel();
        model.setFecha(entity.getFecha());
        model.setMetodo_pago(entity.getMetodo_pago());
        model.setPago_total(entity.getPago_total());
        model.setFk_id_reserva(entity.getFk_id_reserva() != null ? entity.getFk_id_reserva().getId_reserva() : null);
        return model;
    }

    // Model -> Entity (sin relaciones cargadas)
    public static PagoEntity toEntityFromModel(PagoModel model) {
        if (model == null) return null;

        PagoEntity entity = new PagoEntity();
        entity.setFecha(model.getFecha());
        entity.setMetodo_pago(model.getMetodo_pago());
        entity.setPago_total(model.getPago_total());
        return entity;
    }
}