package co.edu.udistrital.taller2.services;

import co.edu.udistrital.taller2.Models.AdminModel;
import co.edu.udistrital.taller2.dtos.AdminDTO;
import co.edu.udistrital.taller2.entitys.AdminEntity;
import co.edu.udistrital.taller2.repos.AdminRepository;
import co.edu.udistrital.taller2.utils.AdminMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements BaseService<AdminEntity, AdminModel, AdminDTO>{

    private final AdminRepository adminRepository;

    @Override
    public AdminEntity save(AdminModel adminModel) {
        AdminEntity toSave = AdminMapper.toEntityFromModel(adminModel);
        if(toSave != null) {
            return adminRepository.save(toSave);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public AdminEntity update(AdminModel adminModel) {
        AdminEntity toSave = AdminMapper.toEntityFromModel(adminModel);
        if(toSave != null) {
            return adminRepository.save(toSave);
        }
        return null;
    }

    @Override
    public AdminDTO findById(Long id) {
        AdminEntity adminEntity = adminRepository.findById(id).orElse(null);
        if(adminEntity != null) {
            return AdminMapper.toDTO(adminEntity);
        }
        return null;
    }

    @Override
    public List<AdminDTO> findAll() {
        return adminRepository.findAll().stream().map(AdminMapper::toDTO).collect(Collectors.toList());
    }
}
