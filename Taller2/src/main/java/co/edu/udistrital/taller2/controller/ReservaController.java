package co.edu.udistrital.taller2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import co.edu.udistrital.taller2.Models.UserModel;

import co.edu.udistrital.taller2.dtos.ReservaDTO;
import co.edu.udistrital.taller2.dtos.HabitacionDTO;
import co.edu.udistrital.taller2.dtos.ClienteDTO;
import co.edu.udistrital.taller2.services.ReservaServiceImpl;
import co.edu.udistrital.taller2.entitys.ReservaEntity;
import co.edu.udistrital.taller2.Models.ReservaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//
@RestController
@RequestMapping("/api/v1/reservas")
public class ReservaController {

    @Autowired
    private ReservaServiceImpl reservaService;
    

    @PostMapping("/save_reserva")
    private ResponseEntity<ReservaEntity> saveReserva(@RequestBody ReservaModel reservaModel) {
        return ResponseEntity.ok(reservaService.save(reservaModel));
    }

    @GetMapping("/{id}")
    private ResponseEntity<ReservaDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(reservaService.findById(id));
    }

    @GetMapping("/habitacion/{id}")
    private ResponseEntity<HabitacionDTO> getAdminGeneral(@PathVariable Long id) {
        return ResponseEntity.ok(reservaService.gethabitacionById(id));
    }

    @GetMapping("/cliente/{id}")
    private ResponseEntity<ClienteDTO> getCliente(@PathVariable Long id) {
        return ResponseEntity.ok(reservaService.getFkClienteById(id));
    }

    @GetMapping("/get_all_reservas")
    private ResponseEntity<List<ReservaDTO>> findAll() {
        return ResponseEntity.ok(reservaService.findAll());
    }

    @PutMapping("/update_reserva")
    private ResponseEntity<ReservaEntity> updateReserva(@RequestBody ReservaModel reservaModel) {
        return ResponseEntity.ok(reservaService.update(reservaModel));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteReserva(@PathVariable Long id) {
        reservaService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
