package co.edu.udistrital.taller2.controller;

import co.edu.udistrital.taller2.dtos.HabitacionDTO;
import co.edu.udistrital.taller2.entitys.HabitacionEntity;
import co.edu.udistrital.taller2.models.HabitacionModel;
import co.edu.udistrital.taller2.services.HabitacionService;
import co.edu.udistrital.taller2.services.HabitacionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habitaciones")
@RequiredArgsConstructor
public class HabitacionController {
    private final HabitacionServiceImpl habitacionService;

    @PostMapping
    public HabitacionEntity create(@RequestBody HabitacionModel model) {
        return habitacionService.save(model);
    }

    @PutMapping("/{id}")
    public HabitacionDTO update(@PathVariable Long id, @RequestBody HabitacionModel model) {
        return habitacionService.update(id, model);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        habitacionService.delete(id);
    }

    @GetMapping("/{id}")
    public HabitacionDTO getById(@PathVariable Long id) {
        return habitacionService.findById(id);
    }

    @GetMapping
    public List<HabitacionDTO> getAll() {
        return habitacionService.findAll();
    }
}