package co.edu.udistrital.taller2.services;

import co.edu.udistrital.taller2.dtos.HabitacionDTO;
import co.edu.udistrital.taller2.entitys.HabitacionEntity;
import co.edu.udistrital.taller2.entitys.HotelEntity;
import co.edu.udistrital.taller2.entitys.TipoHabitacionEntity;
import co.edu.udistrital.taller2.models.HabitacionModel;
import co.edu.udistrital.taller2.repos.HabitacionRepository;
import co.edu.udistrital.taller2.repos.HotelRepository;
import co.edu.udistrital.taller2.repos.TipoHabitacionRepository;
import co.edu.udistrital.taller2.utils.HabitacionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HabitacionServiceImpl implements BaseService<HabitacionEntity, HabitacionModel, HabitacionDTO> {
    private final HabitacionRepository habitacionRepository;
    private final HotelRepository hotelRepository;
    private final TipoHabitacionRepository tipoHabitacionRepository;

    @Override
    public HabitacionEntity save(HabitacionModel model) {
        HotelEntity hotel = hotelRepository.findById(model.getIdHotel()).orElse(null);
        TipoHabitacionEntity tipo = tipoHabitacionRepository.findById(model.getIdTipoHabitacion()).orElse(null);
        if (hotel == null || tipo == null) return null;
        HabitacionEntity entity = HabitacionMapper.toEntity(model, tipo, hotel);
        return habitacionRepository.save(entity);
    }

    @Override
    public HabitacionEntity update(HabitacionModel model) {
        HotelEntity hotel = hotelRepository.findById(model.getIdHotel()).orElse(null);
        TipoHabitacionEntity tipo = tipoHabitacionRepository.findById(model.getIdTipoHabitacion()).orElse(null);
        if (hotel == null || tipo == null) return null;
        HabitacionEntity entity = HabitacionMapper.toEntity(model, tipo, hotel);
        return habitacionRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        habitacionRepository.deleteById(id);
    }

    @Override
    public HabitacionDTO findById(Long id) {
        HabitacionEntity entity = habitacionRepository.findById(id).orElse(null);
        if (entity != null) {
            return HabitacionMapper.toDTO(entity);
        }
        return null;
    }

    @Override
    public List<HabitacionDTO> findAll() {
        return habitacionRepository.findAll().stream().map(HabitacionMapper::toDTO).collect(Collectors.toList());
    }
}