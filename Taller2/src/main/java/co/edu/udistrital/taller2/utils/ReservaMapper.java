package co.edu.udistrital.taller2.utils;

import co.edu.udistrital.taller2.Models.ReservaModel;
import co.edu.udistrital.taller2.dtos.ReservaDTO;
import co.edu.udistrital.taller2.entitys.ReservaEntity;

import java.time.format.DateTimeFormatter;

public class ReservaMapper {
    private ReservaMapper(){}

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    // Entity -> DTO
    public static ReservaDTO toDTO(ReservaEntity entity) {
        if (entity == null) return null;

        ReservaDTO dto = new ReservaDTO();
        dto.setId_reserva(entity.getId_reserva());
        dto.setFecha_inicio(entity.getFecha_inicio() != null ? entity.getFecha_inicio().format(formatter) : null);
        dto.setFecha_final(entity.getFecha_final() != null ? entity.getFecha_final().format(formatter) : null);
        dto.setCantidad_dias(entity.getCantidad_dias());
        dto.setEstado(entity.getEstado());
        dto.setFecha_reserva(entity.getFecha_reserva() != null ? entity.getFecha_reserva().format(formatter) : null);
        dto.setFk_id_habitacion(entity.getFk_id_habitacion() != null ? entity.getFk_id_habitacion().getId_habitacion() : null);
        dto.setFk_id_cliente(entity.getFk_id_cliente() != null ? entity.getFk_id_cliente().getId_cliente() : null);
        return dto;
    }

    // DTO -> Entity (sin recuperar entidades hijas aún)
    public static ReservaEntity toEntityFromDTO(ReservaDTO dto) {
        if (dto == null) return null;

        ReservaEntity entity = new ReservaEntity();
        entity.setId_reserva(dto.getId_reserva());
        entity.setFecha_inicio(dto.getFecha_inicio() != null ? java.time.LocalDateTime.parse(dto.getFecha_inicio(), formatter) : null);
        entity.setFecha_final(dto.getFecha_final() != null ? java.time.LocalDateTime.parse(dto.getFecha_final(), formatter) : null);
        entity.setCantidad_dias(dto.getCantidad_dias());
        entity.setEstado(dto.getEstado());
        entity.setFecha_reserva(dto.getFecha_reserva() != null ? java.time.LocalDateTime.parse(dto.getFecha_reserva(), formatter) : null);
        // Relaciones: estas se deben setear desde fuera si se tienen entidades cargadas
        return entity;
    }

    // Entity -> Model
    public static ReservaModel toModel(ReservaEntity entity) {
        if (entity == null) return null;

        ReservaModel model = new ReservaModel();
        model.setFecha_inicio(entity.getFecha_inicio() != null ? entity.getFecha_inicio().format(formatter) : null);
        model.setFecha_final(entity.getFecha_final() != null ? entity.getFecha_final().format(formatter) : null);
        model.setCantidad_dias(entity.getCantidad_dias());
        model.setEstado(entity.getEstado());
        model.setFecha_reserva(entity.getFecha_reserva() != null ? entity.getFecha_reserva().format(formatter) : null);
        model.setFk_id_habitacion(entity.getFk_id_habitacion() != null ? entity.getFk_id_habitacion().getId_habitacion() : null);
        model.setFk_id_cliente(entity.getFk_id_cliente() != null ? entity.getFk_id_cliente().getId_cliente() : null);
        return model;
    }

    // Model -> Entity (sin relaciones cargadas)
    public static ReservaEntity toEntityFromModel(ReservaModel model) {
        if (model == null) return null;

        ReservaEntity entity = new ReservaEntity();
        entity.setFecha_inicio(model.getFecha_inicio() != null ? java.time.LocalDateTime.parse(model.getFecha_inicio(), formatter) : null);
        entity.setFecha_final(model.getFecha_final() != null ? java.time.LocalDateTime.parse(model.getFecha_final(), formatter) : null);
        entity.setCantidad_dias(model.getCantidad_dias());
        entity.setEstado(model.getEstado());
        entity.setFecha_reserva(model.getFecha_reserva() != null ? java.time.LocalDateTime.parse(model.getFecha_reserva(), formatter) : null);
        // Relaciones se deben cargar y setear desde el servicio con repositorio
        return entity;
    }

    // DTO -> Model
    public static ReservaModel toModelFromDTO(ReservaDTO dto) {
        if (dto == null) return null;

        ReservaModel model = new ReservaModel();
        model.setFecha_inicio(dto.getFecha_inicio());
        model.setFecha_final(dto.getFecha_final());
        model.setCantidad_dias(dto.getCantidad_dias());
        model.setEstado(dto.getEstado());
        model.setFecha_reserva(dto.getFecha_reserva());
        model.setFk_id_habitacion(dto.getFk_id_habitacion());
        model.setFk_id_cliente(dto.getFk_id_cliente());
        return model;
    }

    // Model -> DTO
    public static ReservaDTO toDTOFromModel(ReservaModel model) {
        if (model == null) return null;

        ReservaDTO dto = new ReservaDTO();
        dto.setFecha_inicio(model.getFecha_inicio());
        dto.setFecha_final(model.getFecha_final());
        dto.setCantidad_dias(model.getCantidad_dias());
        dto.setEstado(model.getEstado());
        dto.setFecha_reserva(model.getFecha_reserva());
        dto.setFk_id_habitacion(model.getFk_id_habitacion());
        dto.setFk_id_cliente(model.getFk_id_cliente());
        return dto;
    }
}
