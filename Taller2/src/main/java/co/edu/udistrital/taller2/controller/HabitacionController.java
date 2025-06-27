package co.edu.udistrital.taller2.controller;

import co.edu.udistrital.taller2.dtos.HabitacionDTO;
import co.edu.udistrital.taller2.entitys.HabitacionEntity;
import co.edu.udistrital.taller2.models.HabitacionModel;
import co.edu.udistrital.taller2.services.HabitacionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/habitaciones")
@RequiredArgsConstructor
public class HabitacionController {

    private final HabitacionServiceImpl habitacionService;

    @PostMapping("/save_habitacion")
    private ResponseEntity<HabitacionEntity> saveHabitacion(@RequestBody HabitacionModel habitacionModel) {
        return ResponseEntity.ok(habitacionService.save(habitacionModel));
    }

    @GetMapping("/{id}")
    private ResponseEntity<HabitacionDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(habitacionService.findById(id));
    }

    @GetMapping("/get_all_habitaciones")
    private ResponseEntity<List<HabitacionDTO>> findAll() {
        return ResponseEntity.ok(habitacionService.findAll());
    }

    @PutMapping("/update_habitacion")
    private ResponseEntity<HabitacionEntity> updateHabitacion(@RequestBody HabitacionModel habitacionModel) {
        return ResponseEntity.ok(habitacionService.update(habitacionModel));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteHabitacion(@PathVariable Long id) {
        habitacionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}