package co.edu.udistrital.taller2.services;

import co.edu.udistrital.taller2.Models.PagoModel;
import co.edu.udistrital.taller2.dtos.PagoDTO;
import co.edu.udistrital.taller2.entitys.PagoEntity;
import co.edu.udistrital.taller2.entitys.ReservaEntity;
import co.edu.udistrital.taller2.repos.PagoRepository;
import co.edu.udistrital.taller2.repos.ReservaRepository;
import co.edu.udistrital.taller2.utils.PagoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PagoServiceImpl implements BaseService<PagoEntity, PagoModel, PagoDTO> {

    private final PagoRepository pagoRepository;
    private final ReservaRepository reservaRepository;

    @Override
    public PagoEntity save(PagoModel pagoModel) {
        PagoEntity pagoEntity = PagoMapper.toEntityFromModel(pagoModel);

        if (pagoModel.getFk_id_reserva() != null) {
            ReservaEntity reserva = reservaRepository.findById(pagoModel.getFk_id_reserva())
                    .orElseThrow(() -> new RuntimeException("Reserva no encontrada con ID: " + pagoModel.getFk_id_reserva()));
            pagoEntity.setFk_id_reserva(reserva);
        }

        return pagoRepository.save(pagoEntity);
    }

    @Override
    public void delete(Long id) {
        PagoEntity pagoEntity = pagoRepository.findById(id).orElse(null);
        if (pagoEntity != null) {
            pagoRepository.delete(pagoEntity);
        }
    }

    @Override
    public PagoEntity update(PagoModel pagoModel) {
        PagoEntity updated = PagoMapper.toEntityFromModel(pagoModel);

        if (pagoModel.getFk_id_reserva() != null) {
            ReservaEntity reserva = reservaRepository.findById(pagoModel.getFk_id_reserva())
                    .orElseThrow(() -> new RuntimeException("Reserva no encontrada con ID: " + pagoModel.getFk_id_reserva()));
            updated.setFk_id_reserva(reserva);
        }

        pagoRepository.save(updated);
        return updated;
    }

    @Override
    public PagoDTO findById(Long id) {
        PagoEntity pagoEntity = pagoRepository.findById(id).orElse(null);
        return PagoMapper.toDTO(pagoEntity);
    }

    @Override
    public List<PagoDTO> findAll() {
        return pagoRepository.findAll().stream()
                .map(PagoMapper::toDTO)
                .collect(Collectors.toList());
    }
}