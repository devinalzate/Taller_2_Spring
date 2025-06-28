package co.edu.udistrital.taller2.services;

import co.edu.udistrital.taller2.Models.HotelModel;
import co.edu.udistrital.taller2.dtos.HotelDTO;
import co.edu.udistrital.taller2.entitys.HotelEntity;
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
    public HotelEntity save(HotelModel hotelModel) {
        return hotelRepository.save(HotelMapper.toEntity(hotelModel));
    }

    @Override
    public void delete(Long id) {
        HotelEntity hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel no encontrado con id: " + id));
        hotelRepository.delete(hotel);
    }

    @Override
    public HotelEntity update(HotelModel hotelModel) {
        HotelEntity existing = hotelRepository.findById(hotelModel.getIdHotel())
                .orElseThrow(() -> new ResourceNotFoundException("Hotel no encontrado con id: " + hotelModel.getIdHotel()));
        HotelMapper.updateEntityFromModel(existing, hotelModel);
        return hotelRepository.save(existing);
    }

    @Override
    public HotelDTO findById(Long id) {
        return hotelRepository.findById(id)
                .map(HotelMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel no encontrado con id: " + id));
    }

    @Override
    public List<HotelDTO> findAll() {
        return hotelRepository.findAll().stream()
                .map(HotelMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Clase interna para la excepción personalizada
    public static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }
}
