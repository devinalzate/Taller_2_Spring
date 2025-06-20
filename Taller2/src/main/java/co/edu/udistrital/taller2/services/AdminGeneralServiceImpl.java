package co.edu.udistrital.taller2.services;

import co.edu.udistrital.taller2.Models.AdminGeneralModel;
import co.edu.udistrital.taller2.dtos.AdminGeneralDTO;
import co.edu.udistrital.taller2.entitys.AdminGeneralEntity;
import co.edu.udistrital.taller2.repos.AdminGeneralRepository;
import co.edu.udistrital.taller2.utils.AdminGeneralMapper;
import co.edu.udistrital.taller2.utils.AdminMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminGeneralServiceImpl implements BaseService<AdminGeneralEntity, AdminGeneralModel, AdminGeneralDTO>{

    private final AdminGeneralRepository adminGeneralRepository;

    @Override
    public AdminGeneralEntity save(AdminGeneralModel adminGeneralModel) {
        AdminGeneralEntity adminGeneralEntity = AdminGeneralMapper.toEntityFromModel(adminGeneralModel);
        if(adminGeneralEntity != null){
            return adminGeneralRepository.save(adminGeneralEntity);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        adminGeneralRepository.deleteById(id);
    }

    @Override
    public AdminGeneralEntity update(AdminGeneralModel adminGeneralModel) {
        AdminGeneralEntity adminGeneralEntity = AdminGeneralMapper.toEntityFromModel(adminGeneralModel);
        if(adminGeneralEntity != null){
            return adminGeneralRepository.save(adminGeneralEntity);
        }
        return null;
    }

    @Override
    public AdminGeneralDTO findById(Long id) {
        AdminGeneralDTO toReturn = AdminGeneralMapper.toDTO(adminGeneralRepository.findById(id).orElse(null));
        return toReturn;
    }

    @Override
    public List<AdminGeneralDTO> findAll() {
        return adminGeneralRepository.findAll().stream().map(AdminGeneralMapper::toDTO).collect(Collectors.toList());
    }
}
