package co.edu.udistrital.taller2.services;

import co.edu.udistrital.taller2.Models.UserModel;
import co.edu.udistrital.taller2.dtos.UserDTO;
import co.edu.udistrital.taller2.entitys.UserEntity;
import co.edu.udistrital.taller2.repos.UserRepository;
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

    @Override
    public UserEntity save(UserModel userModel) {
        UserEntity created = UserMapper.toEntityFromModel(userModel);
        userRepository.save(created);
        return created;
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
