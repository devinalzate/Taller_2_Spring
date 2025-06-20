package co.edu.udistrital.taller2.services;

import co.edu.udistrital.taller2.Models.UserModel;
import co.edu.udistrital.taller2.dtos.AdminDTO;
import co.edu.udistrital.taller2.dtos.AdminGeneralDTO;
import co.edu.udistrital.taller2.dtos.EmpleadoDTO;
import co.edu.udistrital.taller2.dtos.UserDTO;
import co.edu.udistrital.taller2.entitys.AdminEntity;
import co.edu.udistrital.taller2.entitys.AdminGeneralEntity;
import co.edu.udistrital.taller2.entitys.EmpleadoEntity;
import co.edu.udistrital.taller2.entitys.UserEntity;
import co.edu.udistrital.taller2.repos.AdminGeneralRepository;
import co.edu.udistrital.taller2.repos.AdminRepository;
import co.edu.udistrital.taller2.repos.EmpleadoRepository;
import co.edu.udistrital.taller2.repos.UserRepository;
import co.edu.udistrital.taller2.utils.AdminGeneralMapper;
import co.edu.udistrital.taller2.utils.AdminMapper;
import co.edu.udistrital.taller2.utils.EmpleadoMapper;
import co.edu.udistrital.taller2.utils.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements BaseService<UserEntity,UserModel, UserDTO> {

    private final UserRepository userRepository;
    private final EmpleadoRepository empleadoRepository;
    private final EmpleadoMapper empleadoMapper;
    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;
    private final AdminGeneralRepository adminGeneralRepository;
    private final AdminGeneralMapper adminGeneralMapper;

    @Override
    public UserEntity save(UserModel userModel) {

        UserEntity userEntity = UserMapper.toEntityFromModel(userModel);
        if (userModel.getFk_id_empleado() != null) {
            EmpleadoEntity empleado = empleadoRepository.findById(userModel.getFk_id_empleado())
                    .orElseThrow(() -> new RuntimeException("Empleado no encontrado con ID: " + userModel.getFk_id_empleado()));
            userEntity.setFk_id_empleado(empleado);
        }
        if (userModel.getFk_id_administrador() != null ){
            AdminEntity admin = adminRepository.findById(userModel.getFk_id_administrador()).orElseThrow(()-> new RuntimeException("Administrador no encontrado con ID: " + userModel.getFk_id_administrador()));
            userEntity.setFk_id_administrador(admin);
        }
        if (userModel.getFk_id_administrador_general() != null ){
            AdminGeneralEntity admin_general = adminGeneralRepository.findById(userModel.getFk_id_administrador_general()).orElseThrow(()-> new RuntimeException("Administrador generalw no encontrado con ID: " + userModel.getFk_id_administrador_general()));
            userEntity.setFk_id_administrador_general(admin_general);
        }
        return userRepository.save(userEntity);
    }

    public EmpleadoDTO getFkEmployeeById(Long id){
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        EmpleadoEntity employeeEntity = userEntity.getFk_id_empleado();
        if(employeeEntity != null){
            return empleadoMapper.toDTO(employeeEntity);
        }
        return null;
    }

    public AdminDTO getFkAdminById(Long id){
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        AdminEntity adminEntity = userEntity.getFk_id_administrador();
        if(adminEntity != null){
            return adminMapper.toDTO(adminEntity);
        }
        return null;
    }

    public AdminGeneralDTO getFkAdminGeneralById(Long id){
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        AdminGeneralEntity admin = userEntity.getFk_id_administrador_general();
        if(admin != null){
            return adminGeneralMapper.toDTO(admin);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity != null) {
            userRepository.delete(userEntity);
        }
    }

    @Override
    public UserEntity update(UserModel userModel) {
        UserEntity updated = UserMapper.toEntityFromModel(userModel);
        userRepository.save(updated);
        return updated;
    }

    @Override
    public UserDTO findById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        UserDTO result = UserMapper.toDTO(userEntity);
        return result;
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().
                map(UserMapper::toDTO).
                collect(Collectors.toList());
    }
}
