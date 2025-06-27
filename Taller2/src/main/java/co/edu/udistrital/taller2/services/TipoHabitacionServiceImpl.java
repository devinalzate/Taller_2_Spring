package co.edu.udistrital.taller2.services;

import co.edu.udistrital.taller2.dtos.TipoHabitacionDTO;
import co.edu.udistrital.taller2.entitys.HotelEntity;
import co.edu.udistrital.taller2.entitys.TipoHabitacionEntity;
import co.edu.udistrital.taller2.models.TipoHabitacionModel;
import co.edu.udistrital.taller2.repos.HotelRepository;
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
    private final HotelRepository hotelRepository;

    @Override
    public TipoHabitacionEntity save(TipoHabitacionModel tipoHabitacionModel) {
        HotelEntity guardar = hotelRepository.findById(tipoHabitacionModel.getIdHotel()).orElse(null);
        if (guardar == null) return null;
        TipoHabitacionEntity entity = TipoHabitacionMapper.toEntity(tipoHabitacionModel, guardar);
        return tipoHabitacionRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        tipoHabitacionRepository.deleteById(id);
    }

    @Override
    public TipoHabitacionEntity update(TipoHabitacionModel model) {
        HotelEntity hotel = hotelRepository.findById(model.getIdHotel()).orElse(null);
        if (hotel == null) return null;
        TipoHabitacionEntity tipoHabitacionEntity = TipoHabitacionMapper.toEntityFromModel(model, hotel);
        if (tipoHabitacionEntity != null){
            return tipoHabitacionRepository.save(tipoHabitacionEntity);
        }
        return null;
    }

    @Override
    public TipoHabitacionDTO findById(Long id) {
        TipoHabitacionEntity tipoHabitacionEntity = tipoHabitacionRepository.findById(id).orElse(null);
        if (tipoHabitacionEntity != null) {
            TipoHabitacionDTO tipoHabitacionDTO = TipoHabitacionMapper.toDTO(tipoHabitacionEntity);
            return tipoHabitacionDTO;
        }
        return null;
    }

    @Override
    public List<TipoHabitacionDTO> findAll() {
        List<TipoHabitacionEntity> tiposHabitacion = tipoHabitacionRepository.findAll();
        List<TipoHabitacionDTO> tipoHabitacionDTOS = new ArrayList<>();

        for(TipoHabitacionEntity tipoHabitacion : tiposHabitacion){
            tipoHabitacionDTOS.add(tiposHabitacionMapper.toDTO(tipoHabitacion));
        }
        return tipoHabitacionDTOS;
    }
}