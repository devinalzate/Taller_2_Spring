package co.edu.udistrital.taller2.controller;

import co.edu.udistrital.taller2.Models.EmpleadoModel;
import co.edu.udistrital.taller2.dtos.EmpleadoDTO;
import co.edu.udistrital.taller2.entitys.EmpleadoEntity;
import co.edu.udistrital.taller2.services.EmpleadoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//
@RestController
@RequestMapping("/api/v1/empleados")
@RequiredArgsConstructor
public class EmpleadoController {

    private final EmpleadoServiceImpl empleadoService;

    @PostMapping("/save_empleado")
    private ResponseEntity<EmpleadoEntity> saveEmpleado(@RequestBody EmpleadoModel empleadoModel) {
        return ResponseEntity.ok(empleadoService.save(empleadoModel));
    }

    @GetMapping("/{id}")
    private ResponseEntity<EmpleadoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(empleadoService.findById(id));
    }

    @GetMapping("/get_all_empleados")
    private ResponseEntity<List<EmpleadoDTO>> findAll() {
        return ResponseEntity.ok(empleadoService.findAll());
    }

    @PutMapping("/update_empleado")
    private ResponseEntity<EmpleadoEntity> updateEmpleado(@RequestBody EmpleadoModel empleadoModel) {
        return ResponseEntity.ok(empleadoService.update(empleadoModel));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteEmpleado(@PathVariable Long id) {
        empleadoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
