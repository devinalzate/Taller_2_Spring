package co.edu.udistrital.taller2.services;

import co.edu.udistrital.taller2.Models.ClienteModel;
import co.edu.udistrital.taller2.dtos.ClienteDTO;
import co.edu.udistrital.taller2.entitys.ClienteEntity;
import co.edu.udistrital.taller2.repos.ClienteRepository;
import co.edu.udistrital.taller2.utils.ClienteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements BaseService<ClienteEntity, ClienteModel, ClienteDTO> {

    private final ClienteRepository clienteRepository;
    

    @Override
    public ClienteEntity save(ClienteModel clienteModel) {
        ClienteEntity clienteEntity = ClienteMapper.toEntityFromModel(clienteModel);
        if(clienteEntity != null){
            return clienteRepository.save(clienteEntity);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public ClienteEntity update(ClienteModel clienteModel) {
        ClienteEntity guardar = ClienteMapper.toEntityFromModel(clienteModel);
        if(guardar != null && guardar.getId_cliente() != null){
            return clienteRepository.save(guardar);
        }
        return null;
    }

    @Override
    public ClienteDTO findById(Long id) {
        ClienteEntity cliente = clienteRepository.findById(id).orElse(null);
        if(cliente != null){
            return ClienteMapper.toDTO(cliente);
        }
        return null;
    }

    @Override
    public List<ClienteDTO> findAll() {
        List<ClienteEntity> clientes = clienteRepository.findAll();
        List<ClienteDTO> clientesDTOS = new ArrayList<>();
        for(ClienteEntity cliente : clientes){
            clientesDTOS.add(ClienteMapper.toDTO(cliente));
        }
        return clientesDTOS;
    }
}
