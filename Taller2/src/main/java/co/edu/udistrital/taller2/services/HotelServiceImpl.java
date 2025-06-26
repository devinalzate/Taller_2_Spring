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
public class HotelServiceImpl implements BaseService<HotelEntity, HotelModel, HotelDTO> {
    private final HotelRepository hotelRepository;

    @Override
    public HotelEntity save(HotelModel model) {
        HotelEntity entity = HotelMapper.toEntity(model);
        return hotelRepository.save(entity);
    }

    @Override
    public HotelEntity update(HotelModel model) {
        HotelEntity entity = HotelMapper.toEntity(model);
        return hotelRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        hotelRepository.deleteById(id);
    }

    @Override
    public HotelDTO findById(Long id) {
        HotelEntity entity = hotelRepository.findById(id).orElse(null);
        if (entity != null) {
            return HotelMapper.toDTO(entity);
        }
        return null;
    }

    @Override
    public List<HotelDTO> findAll() {
        return hotelRepository.findAll().stream().map(HotelMapper::toDTO).collect(Collectors.toList());
    }
}