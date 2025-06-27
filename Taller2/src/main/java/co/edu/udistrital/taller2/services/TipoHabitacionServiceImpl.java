package co.edu.udistrital.taller2.services;

import co.edu.udistrital.taller2.Models.TipoHabitacionModel;
import co.edu.udistrital.taller2.dtos.TipoHabitacionDTO;
import co.edu.udistrital.taller2.entitys.TipoHabitacionEntity;
import co.edu.udistrital.taller2.repos.TipoHabitacionRepository;
import co.edu.udistrital.taller2.utils.TipoHabitacionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TipoHabitacionServiceImpl implements BaseService<TipoHabitacionEntity, TipoHabitacionModel, TipoHabitacionDTO> {

    private final TipoHabitacionRepository tipoHabitacionRepository;

    @Override
    public TipoHabitacionEntity save(TipoHabitacionModel model) {
        return tipoHabitacionRepository.save(TipoHabitacionMapper.toEntity(model));
    }

    @Override
    public void delete(Long id) {
        TipoHabitacionEntity entity = tipoHabitacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tipo de habitación no encontrado con id: " + id));
        tipoHabitacionRepository.delete(entity);
    }

    @Override
    public TipoHabitacionEntity update(TipoHabitacionModel model) {
        TipoHabitacionEntity existing = tipoHabitacionRepository.findById(model.getIdTipoHabitacion())
                .orElseThrow(() -> new ResourceNotFoundException("Tipo de habitación no encontrado con id: " + model.getIdTipoHabitacion()));

        TipoHabitacionMapper.updateEntityFromModel(existing, model);
        return tipoHabitacionRepository.save(existing);
    }

    @Override
    public TipoHabitacionDTO findById(Long id) {
        return tipoHabitacionRepository.findById(id)
                .map(TipoHabitacionMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Tipo de habitación no encontrado con id: " + id));
    }

    @Override
    public List<TipoHabitacionDTO> findAll() {
        return tipoHabitacionRepository.findAll().stream()
                .map(TipoHabitacionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }
}
