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
public class TipoHabitacionServiceImpl implements TipoHabitacionService {
    private final TipoHabitacionRepository tipoHabitacionRepository;
    private final HotelRepository hotelRepository;

    @Override
    public TipoHabitacionDTO save(TipoHabitacionModel model) {
        HotelEntity hotel = hotelRepository.findById(model.getIdHotel()).orElse(null);
        if (hotel == null) return null;
        TipoHabitacionEntity entity = TipoHabitacionMapper.toEntity(model, hotel);
        return TipoHabitacionMapper.toDTO(tipoHabitacionRepository.save(entity));
    }

    @Override
    public TipoHabitacionDTO update(Integer id, TipoHabitacionModel model) {
        TipoHabitacionEntity entity = tipoHabitacionRepository.findById(id).orElse(null);
        if (entity == null) return null;
        HotelEntity hotel = hotelRepository.findById(model.getIdHotel()).orElse(null);
        if (hotel == null) return null;
        entity.setHotel(hotel);
        entity.setNombre(model.getNombre());
        entity.setCantidad(model.getCantidad());
        return TipoHabitacionMapper.toDTO(tipoHabitacionRepository.save(entity));
    }

    @Override
    public void delete(Integer id) {
        tipoHabitacionRepository.deleteById(id);
    }

    @Override
    public TipoHabitacionDTO findById(Integer id) {
        return tipoHabitacionRepository.findById(id).map(TipoHabitacionMapper::toDTO).orElse(null);
    }

    @Override
    public List<TipoHabitacionDTO> findAll() {
        return tipoHabitacionRepository.findAll().stream().map(TipoHabitacionMapper::toDTO).collect(Collectors.toList());
    }
}
