package co.edu.udistrital.taller2.services;

import co.edu.udistrital.taller2.Models.EmpleadoModel;
import co.edu.udistrital.taller2.dtos.EmpleadoDTO;
import co.edu.udistrital.taller2.entitys.EmpleadoEntity;
import co.edu.udistrital.taller2.repos.EmpleadoRepository;
import co.edu.udistrital.taller2.utils.EmpleadoMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
//
@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements BaseService<EmpleadoEntity, EmpleadoModel, EmpleadoDTO> {

    private final EmpleadoRepository empleadoRepository;
    private final EmpleadoMapper empleadoMapper;

    @Override
    public EmpleadoEntity save(EmpleadoModel empleadoModel) {
        EmpleadoEntity guardar = empleadoMapper.toEntityFromModel(empleadoModel);
        if(guardar != null){
            return empleadoRepository.save(guardar);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        empleadoRepository.deleteById(id);
    }

    @Override
    public EmpleadoEntity update(EmpleadoModel empleadoModel) {
        EmpleadoEntity guardar = empleadoMapper.toEntityFromModel(empleadoModel);
        if(guardar != null){
            return empleadoRepository.save(guardar);
        }
        return null;
    }

    @Override
    public EmpleadoDTO findById(Long id) {
        EmpleadoEntity empleado = empleadoRepository.findById(id).orElse(null);
        if(empleado != null){
            EmpleadoDTO empleadoDTO = empleadoMapper.toDTO(empleado);
            return empleadoDTO;
        }
        return null;
    }

    @Override
    public List<EmpleadoDTO> findAll() {
        List<EmpleadoEntity> empleados = empleadoRepository.findAll();
        List<EmpleadoDTO> empleadosDTOS = new ArrayList<>();

        for(EmpleadoEntity empleado : empleados){
            empleadosDTOS.add(empleadoMapper.toDTO(empleado));
        }
        return empleadosDTOS;
    }
}
