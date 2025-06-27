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
    private final HotelMapper hotelMapper;

    @Override
    public HotelEntity save(HotelModel hotelModel) {
        HotelEntity guardar = HotelMapper.toEntityFromModel(hotelModel);
        if(guardar!= null){
            return hotelRepository.save(guardar);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        hotelRepository.deleteById(id);
    }

    @Override
    public HotelEntity update(HotelModel hotelModel) {
        HotelEntity guardar = HotelMapper.toEntityFromModel(hotelModel);
        if (guardar != null) {
            return hotelRepository.save(guardar);
        }
        return null;
    }

    @Override
    public HotelDTO findById(Long id) {
        HotelEntity hotel = hotelRepository.findById(id).orElse(null);
        if (hotel != null) {
            return HotelMapper.toDTO(hotel);
        }
        return null;
    }

    @Override
    public List<HotelDTO> findAll() {
        List<HotelEntity> hotel = hotelRepository.findAll();
        List<HotelDTO> hotelesDTOS = new ArrayList<>();

        for(HotelEntity hotel : hoteles){
            hotelesDTOS.add(hotelMapper.toDTO(hotel));
        }
        return hotelesDTOS;
    }
}