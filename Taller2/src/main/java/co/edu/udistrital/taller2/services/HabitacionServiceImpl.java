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
    public HabitacionEntity save(HabitacionModel hotelModel) {
        HotelEntity hotel = hotelRepository.findById(hotelModel.getIdHotel()).orElse(null);
        TipoHabitacionEntity tipo = tipoHabitacionRepository.findById(hotelModel.getIdTipoHabitacion()).orElse(null);
        if (hotel == null || tipo == null) return null;
        HabitacionEntity guardar = HabitacionMapper.toEntity(hotelModel, tipo, hotel);
        return habitacionRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        habitacionRepository.deleteById(id);
    }

    @Override
    public HabitacionEntity update(HabitacionModel hotelModel) {
        HotelEntity hotel = hotelRepository.findById(hotelModel.getIdHotel()).orElse(null);
        TipoHabitacionEntity tipo = tipoHabitacionRepository.findById(hotelModel.getIdTipoHabitacion()).orElse(null);
        if (hotel == null || tipo == null) return null;
        HabitacionEntity guardar = HabitacionMapper.toEntity(hotelModel, tipo, hotel);
        return habitacionRepository.save(guardar);
    }


    @Override
    public HabitacionDTO findById(Long id) {
        HabitacionEntity entity = habitacionRepository.findById(id).orElse(null);
        if (entity != null) {
            HabitacionDTO habitacionDTO = HabitacionMapper.toDTO(entity);
            return habitacionDTO;
        }
        return null;
    }

    @Override
    public List<HabitacionDTO> findAll() {
        List<HabitacionEntity> habitaciones = habitacionRepository.findAll();
        List<HabitacionDTO> habitacionesDTOS = new ArrayList<>();

        for(HabitacionEntity habitacion : habitaciones){
            habitacionesDTOS.add(habitacionMapper.toDTO(habitacion));
        }
        return habitacionesDTOS;
    }
}