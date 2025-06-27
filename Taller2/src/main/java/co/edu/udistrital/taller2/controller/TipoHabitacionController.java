package co.edu.udistrital.taller2.controller;

import co.edu.udistrital.taller2.dtos.TipoHabitacionDTO;
import co.edu.udistrital.taller2.models.TipoHabitacionModel;
import co.edu.udistrital.taller2.services.TipoHabitacionServiceImpl;
import co.edu.udistrital.taller2.entitys.TipoHabitacionEntity;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tipos-habitacion")
@RequiredArgsConstructor
public class TipoHabitacionController {
    private final TipoHabitacionServiceImpl tipoHabitacionService;

    @PostMapping("/save_tipo-habitacion")
    private ResponseEntity<TipoHabitacionEntity> saveTipohabitacion(@RequestBody TipoHabitacionModel tipoHabitacionModel) {
        return ResponseEntity.ok(tipoHabitacionService.save(tipoHabitacionModel));
    }

    @GetMapping("/{id}")
    private ResponseEntity<TipoHabitacionDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(tipoHabitacionService.findById(id));
    }

    @GetMapping("/get_all_tipos_habitacion")
    private ResponseEntity<List<TipoHabitacionDTO>> findAll() {
        return ResponseEntity.ok(tipoHabitacionService.findAll());
    }

    @PutMapping("/{id}")
    private ResponseEntity<TipoHabitacionEntity> updateTipoHabitacion(@RequestBody TipoHabitacionModel tipoHabitacionModel) {
        return ResponseEntity.ok(tipoHabitacionService.update(tipoHabitacionModel));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteTipoHabitacion(@PathVariable Long id) {
        tipoHabitacionService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
