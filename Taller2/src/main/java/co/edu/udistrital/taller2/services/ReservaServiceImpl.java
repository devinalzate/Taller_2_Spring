package co.edu.udistrital.taller2.services;

import co.edu.udistrital.taller2.Models.ReservaModel;
import co.edu.udistrital.taller2.dtos.ClienteDTO;
import co.edu.udistrital.taller2.dtos.HabitacionDTO;
import co.edu.udistrital.taller2.dtos.ReservaDTO;
import co.edu.udistrital.taller2.entitys.ClienteEntity;
import co.edu.udistrital.taller2.entitys.HabitacionEntity;
import co.edu.udistrital.taller2.entitys.ReservaEntity;
import co.edu.udistrital.taller2.repos.ClienteRepository;
import co.edu.udistrital.taller2.repos.HabitacionRepository;
import co.edu.udistrital.taller2.repos.ReservaRepository;
import co.edu.udistrital.taller2.utils.ClienteMapper;
import co.edu.udistrital.taller2.utils.HabitacionMapper;
import co.edu.udistrital.taller2.utils.ReservaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservaServiceImpl implements BaseService<ReservaEntity, ReservaModel, ReservaDTO> {

    private final ReservaRepository reservaRepository;
    private final ClienteRepository clienteRepository;
    private final HabitacionRepository habitacionRepository;
    private final ClienteMapper clienteMapper;
    private final HabitacionMapper habitacionMapper;

    @Override
    public ReservaEntity save(ReservaModel reservaModel) {
        ReservaEntity reservaEntity = ReservaMapper.toEntityFromModel(reservaModel);

        if (reservaModel.getFk_id_cliente() != null) {
            ClienteEntity cliente = clienteRepository.findById(reservaModel.getFk_id_cliente())
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + reservaModel.getFk_id_cliente()));
            reservaEntity.setFk_id_cliente(cliente);
        }
        if (reservaModel.getFk_id_habitacion() != null) {
            HabitacionEntity habitacion = habitacionRepository.findById(reservaModel.getFk_id_habitacion())
                    .orElseThrow(() -> new RuntimeException("Habitación no encontrada con ID: " + reservaModel.getFk_id_habitacion()));
            reservaEntity.setFk_id_habitacion(habitacion);
        }
        return reservaRepository.save(reservaEntity);
    }

    public ClienteDTO getFkClienteById(Long id) {
        ReservaEntity reservaEntity = reservaRepository.findById(id).orElse(null);
        ClienteEntity cliente = reservaEntity != null ? reservaEntity.getFk_id_cliente() : null;
        if (cliente != null) {
            return clienteMapper.toDTO(cliente);
        }
        return null;
    }

    public HabitacionDTO getFkHabitacionById(Long id) {
        ReservaEntity reservaEntity = reservaRepository.findById(id).orElse(null);
        HabitacionEntity habitacion = reservaEntity != null ? reservaEntity.getFk_id_habitacion() : null;
        if (habitacion != null) {
            return habitacionMapper.toDTO(habitacion);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        ReservaEntity reservaEntity = reservaRepository.findById(id).orElse(null);
        if (reservaEntity != null) {
            reservaRepository.delete(reservaEntity);
        }
    }

    @Override
    public ReservaEntity update(ReservaModel reservaModel) {
        ReservaEntity updated = ReservaMapper.toEntityFromModel(reservaModel);
        reservaRepository.save(updated);
        return updated;
    }

    @Override
    public ReservaDTO findById(Long id) {
        ReservaEntity reservaEntity = reservaRepository.findById(id).orElse(null);
        return ReservaMapper.toDTO(reservaEntity);
    }

    @Override
    public List<ReservaDTO> findAll() {
        return reservaRepository.findAll().stream()
                .map(ReservaMapper::toDTO)
                .collect(Collectors.toList());
    }
}
