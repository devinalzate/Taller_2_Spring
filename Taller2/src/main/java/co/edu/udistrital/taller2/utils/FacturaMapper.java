package co.edu.udistrital.taller2.utils;

import co.edu.udistrital.taller2.Models.FacturaModel;
import co.edu.udistrital.taller2.dtos.FacturaDTO;
import co.edu.udistrital.taller2.entitys.FacturaEntity;

public class FacturaMapper {
    private FacturaMapper() {}

    // Entity -> DTO
    public static FacturaDTO toDTO(FacturaEntity entity) {
        if (entity == null) return null;

        FacturaDTO dto = new FacturaDTO();
        dto.setId_factura(entity.getId_factura());
        dto.setFecha_emision(entity.getFecha_emision());
        dto.setValor_total(entity.getValor_total() != null ? entity.getValor_total().intValue() : null);
        dto.setFk_id_reserva(entity.getFk_id_reserva() != null ? entity.getFk_id_reserva().getId_reserva() : null);
        dto.setFk_id_pago(entity.getFk_id_pago() != null ? entity.getFk_id_pago().getId_pago() : null);
        return dto;
    }

    // DTO -> Entity (sin recuperar entidades hijas aún)
    public static FacturaEntity toEntityFromDTO(FacturaDTO dto) {
        if (dto == null) return null;

        FacturaEntity entity = new FacturaEntity();
        entity.setId_factura(dto.getId_factura());
        entity.setFecha_emision(dto.getFecha_emision());
        entity.setValor_total(dto.getValor_total() != null ? dto.getValor_total().longValue() : null);
        // Relaciones: estas se deben setear desde fuera si se tienen entidades cargadas
        return entity;
    }

    // Entity -> Model
    public static FacturaModel toModel(FacturaEntity entity) {
        if (entity == null) return null;

        FacturaModel model = new FacturaModel();
        model.setId_factura(entity.getId_factura());
        model.setFecha_emision(entity.getFecha_emision());
        model.setValor_total(entity.getValor_total() != null ? entity.getValor_total().intValue() : null);
        model.setFk_id_reserva(entity.getFk_id_reserva() != null ? entity.getFk_id_reserva().getId_reserva() : null);
        model.setFk_id_pago(entity.getFk_id_pago() != null ? entity.getFk_id_pago().getId_pago() : null);
        return model;
    }

    // Model -> Entity (sin relaciones cargadas)
    public static FacturaEntity toEntityFromModel(FacturaModel model) {
        if (model == null) return null;

        FacturaEntity entity = new FacturaEntity();
        entity.setId_factura(model.getId_factura());
        entity.setFecha_emision(model.getFecha_emision());
        entity.setValor_total(model.getValor_total() != null ? model.getValor_total().longValue() : null);
        // Relaciones se deben cargar y setear desde el servicio con repositorio
        return entity;
    }

    // DTO -> Model
    public static FacturaModel toModelFromDTO(FacturaDTO dto) {
        if (dto == null) return null;

        FacturaModel model = new FacturaModel();
        model.setId_factura(dto.getId_factura());
        model.setFecha_emision(dto.getFecha_emision());
        model.setValor_total(dto.getValor_total());
        model.setFk_id_reserva(dto.getFk_id_reserva());
        model.setFk_id_pago(dto.getFk_id_pago());
        return model;
    }

    // Model -> DTO
    public static FacturaDTO toDTOFromModel(FacturaModel model) {
        if (model == null) return null;

        FacturaDTO dto = new FacturaDTO();
        dto.setId_factura(model.getId_factura());
        dto.setFecha_emision(model.getFecha_emision());
        dto.setValor_total(model.getValor_total());
        dto.setFk_id_reserva(model.getFk_id_reserva());
        dto.setFk_id_pago(model.getFk_id_pago());
        return dto;
    }
}