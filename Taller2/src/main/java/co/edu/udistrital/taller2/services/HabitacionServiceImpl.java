package co.edu.udistrital.taller2.services;

import co.edu.udistrital.taller2.Models.HabitacionModel;
import co.edu.udistrital.taller2.dtos.HabitacionDTO;
import co.edu.udistrital.taller2.entitys.HabitacionEntity;
import co.edu.udistrital.taller2.entitys.HotelEntity;
import co.edu.udistrital.taller2.entitys.TipoHabitacionEntity;
import co.edu.udistrital.taller2.models.HabitacionModel;
import co.edu.udistrital.taller2.repos.HabitacionRepository;
import co.edu.udistrital.taller2.repos.HotelRepository;
import co.edu.udistrital.taller2.repos.TipoHabitacionRepository;
import co.edu.udistrital.taller2.utils.HabitacionMapper;
import co.edu.udistrital.taller2.utils.HotelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return habitacionRepository.save(guardar);
    }

    @Override
    public void delete(Long id) {
        habitacionRepository.deleteById(id);
    }

    @Override
    public HabitacionEntity update(HabitacionModel model) {
        HabitacionEntity existing = habitacionRepository.findById(model.getIdHabitacion())
                .orElseThrow(() -> new ResourceNotFoundException("Habitación no encontrada"));

        // Actualizar campos necesarios
        existing.setNumeroHabitacion(model.getNumeroHabitacion());
        existing.setPrecioDia(model.getPrecioDia());
        existing.setDisponible(model.getDisponible());

        HotelEntity hotel = hotelRepository.findById(model.getIdHotel())
                .orElseThrow(() -> new ResourceNotFoundException("Hotel no encontrado"));
        TipoHabitacionEntity tipo = tipoHabitacionRepository.findById(model.getIdTipoHabitacion())
                .orElseThrow(() -> new ResourceNotFoundException("Tipo de habitación no encontrado"));

        existing.setHotel(hotel);
        existing.setTipoHabitacion(tipo);

        return habitacionRepository.save(existing);
    }


    @Override
    public HabitacionDTO findById(Long id) {
        return habitacionRepository.findById(id)
                .map(HabitacionMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Habitación no encontrada"));
    }

    @Override
    public List<HabitacionDTO> findAll() {
        return habitacionRepository.findAll().stream()
                .map(HabitacionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

    HotelEntity hotel = hotelRepository.findById(model.getIdHotel())
            .orElseThrow(() -> new ResourceNotFoundException("Hotel no encontrado"));


}