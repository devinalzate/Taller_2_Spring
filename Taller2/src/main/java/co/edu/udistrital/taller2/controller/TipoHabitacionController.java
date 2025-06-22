package co.edu.udistrital.taller2.controllers;

import co.edu.udistrital.taller2.dtos.TipoHabitacionDTO;
import co.edu.udistrital.taller2.models.TipoHabitacionModel;
import co.edu.udistrital.taller2.services.TipoHabitacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos-habitacion")
@RequiredArgsConstructor
public class TipoHabitacionController {
    private final TipoHabitacionService tipoHabitacionService;

    @PostMapping
    public TipoHabitacionDTO create(@RequestBody TipoHabitacionModel model) {
        return tipoHabitacionService.save(model);
    }

    @PutMapping("/{id}")
    public TipoHabitacionDTO update(@PathVariable Integer id, @RequestBody TipoHabitacionModel model) {
        return tipoHabitacionService.update(id, model);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        tipoHabitacionService.delete(id);
    }

    @GetMapping("/{id}")
    public TipoHabitacionDTO getById(@PathVariable Integer id) {
        return tipoHabitacionService.findById(id);
    }

    @GetMapping
    public List<TipoHabitacionDTO> getAll() {
        return tipoHabitacionService.findAll();
    }
}
