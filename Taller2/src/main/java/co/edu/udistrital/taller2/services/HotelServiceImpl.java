package co.edu.udistrital.taller2.services;

import co.edu.udistrital.taller2.dtos.HotelDTO;
import co.edu.udistrital.taller2.entitys.HotelEntity;
import co.edu.udistrital.taller2.models.HotelModel;
import co.edu.udistrital.taller2.repos.HotelRepository;
import co.edu.udistrital.taller2.utils.HotelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    @Override
    public HotelDTO save(HotelModel model) {
        HotelEntity entity = HotelMapper.toEntity(model);
        return HotelMapper.toDTO(hotelRepository.save(entity));
    }

    @Override
    public HotelDTO update(Integer id, HotelModel model) {
        HotelEntity entity = hotelRepository.findById(id).orElse(null);
        if (entity == null) return null;
        entity.setNombre(model.getNombre());
        entity.setCiudad(model.getCiudad());
        entity.setTelefono(model.getTelefono());
        entity.setCorreo(model.getCorreo());
        entity.setDireccion(model.getDireccion());
        return HotelMapper.toDTO(hotelRepository.save(entity));
    }

    @Override
    public void delete(Integer id) {
        hotelRepository.deleteById(id);
    }

    @Override
    public HotelDTO findById(Integer id) {
        return hotelRepository.findById(id).map(HotelMapper::toDTO).orElse(null);
    }

    @Override
    public List<HotelDTO> findAll() {
        return hotelRepository.findAll().stream().map(HotelMapper::toDTO).collect(Collectors.toList());
    }
}
