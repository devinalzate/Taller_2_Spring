package co.edu.udistrital.taller2.controllers;

import co.edu.udistrital.taller2.dtos.HotelDTO;
import co.edu.udistrital.taller2.models.HotelModel;
import co.edu.udistrital.taller2.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hoteles")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @PostMapping
    public HotelDTO create(@RequestBody HotelModel model) {
        return hotelService.save(model);
    }

    @PutMapping("/{id}")
    public HotelDTO update(@PathVariable Long id, @RequestBody HotelModel model) {
        return hotelService.update(id, model);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        hotelService.delete(id);
    }

    @GetMapping("/{id}")
    public HotelDTO getById(@PathVariable Long id) {
        return hotelService.findById(id);
    }

    @GetMapping
    public List<HotelDTO> getAll() {
        return hotelService.findAll();
    }
}
