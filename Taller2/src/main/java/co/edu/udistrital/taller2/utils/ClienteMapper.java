package co.edu.udistrital.taller2.utils;

import co.edu.udistrital.taller2.dtos.ClienteDTO;
import co.edu.udistrital.taller2.Models.ClienteModel;
import co.edu.udistrital.taller2.entitys.ClienteEntity;
import org.springframework.stereotype.Component;
//
@Component
public class ClienteMapper {
    public ClienteMapper() {}

    public static ClienteDTO toDTO(ClienteEntity entity) {
        if (entity == null) return null;

        return ClienteDTO.builder()
                .id_cliente(entity.getId_cliente())
                .primer_nombre(entity.getPrimer_nombre())
                .segundo_nombre(entity.getSegundo_nombre())
                .primer_apellido(entity.getPrimer_apellido())
                .segundo_apellido(entity.getSegundo_apellido())
                .cedula(entity.getCedula())
                .direccion(entity.getDireccion())
                .build();
    }

    public static ClienteEntity toEntityFromDTO(ClienteEntity dto) {
        if (dto == null) return null;

        return ClienteEntity.builder()
                .id_cliente(dto.getId_cliente())
                .primer_nombre(dto.getPrimer_nombre())
                .segundo_nombre(dto.getSegundo_nombre())
                .primer_apellido(dto.getPrimer_apellido())
                .segundo_apellido(dto.getSegundo_apellido())
                .cedula(dto.getCedula())
                .direccion(dto.getDireccion())
                .build();
    }

    public static ClienteEntity toEntityFromModel(ClienteModel model) {
        if (model == null) return null;

        return ClienteEntity.builder()
                .primer_nombre(model.getPrimer_nombre())
                .segundo_nombre(model.getSegundo_nombre())
                .primer_apellido(model.getPrimer_apellido())
                .segundo_apellido(model.getSegundo_apellido())
                .cedula(model.getCedula())
                .direccion(model.getDireccion())
                .build();
    }

    public static ClienteDTO toModel(ClienteModel entity) {
        if (entity == null) return null;
        return ClienteDTO.builder()
                .primer_nombre(entity.getPrimer_nombre())
                .segundo_nombre(entity.getSegundo_nombre())
                .primer_apellido(entity.getPrimer_apellido())
                .segundo_apellido(entity.getSegundo_apellido())
                .cedula(entity.getCedula())
                .direccion(entity.getDireccion())
                .build();
    }


} 