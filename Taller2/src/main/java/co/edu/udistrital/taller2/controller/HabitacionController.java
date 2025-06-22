package co.edu.udistrital.taller2.controllers;

import co.edu.udistrital.taller2.dtos.HabitacionDTO;
import co.edu.udistrital.taller2.models.HabitacionModel;
import co.edu.udistrital.taller2.services.HabitacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habitaciones")
@RequiredArgsConstructor
public class HabitacionController {
    private final HabitacionService habitacionService;

    @PostMapping
    public HabitacionDTO create(@RequestBody HabitacionModel model) {
        return habitacionService.save(model);
    }

    @PutMapping("/{id}")
    public HabitacionDTO update(@PathVariable Integer id, @RequestBody HabitacionModel model) {
        return habitacionService.update(id, model);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        habitacionService.delete(id);
    }

    @GetMapping("/{id}")
    public HabitacionDTO getById(@PathVariable Integer id) {
        return habitacionService.findById(id);
    }

    @GetMapping
    public List<HabitacionDTO> getAll() {
        return habitacionService.findAll();
    }
}
