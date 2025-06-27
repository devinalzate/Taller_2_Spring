package co.edu.udistrital.taller2.controller;

import co.edu.udistrital.taller2.Models.ClienteModel;
import co.edu.udistrital.taller2.dtos.ClienteDTO;
import co.edu.udistrital.taller2.entitys.ClienteEntity;
import co.edu.udistrital.taller2.repos.ClienteRepository;
import co.edu.udistrital.taller2.services.ClienteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor

public class ClienteController {

    private final ClienteServiceImpl clienteService;


    @PostMapping("/save_cliente")
    private ResponseEntity<ClienteEntity> saveCliente(@RequestBody ClienteModel model) {
        return ResponseEntity.ok(clienteService.save(model));
    }

    @PutMapping("/update_admin")
    private ResponseEntity<ClienteEntity> updateCliente(@RequestBody ClienteModel model) {
        return ResponseEntity.ok(clienteService.update(model));
    }

    @GetMapping("/get_admins")
    private ResponseEntity<List<ClienteDTO>> getClientes() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<ClienteDTO> getCliente(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
