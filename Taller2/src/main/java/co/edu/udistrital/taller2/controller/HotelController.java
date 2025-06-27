package co.edu.udistrital.taller2.controller;

import co.edu.udistrital.taller2.Models.HotelModel;
import co.edu.udistrital.taller2.dtos.HotelDTO;
import co.edu.udistrital.taller2.services.HotelServiceImpl;
import co.edu.udistrital.taller2.entitys.HotelEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hoteles")
@RequiredArgsConstructor
public class HotelController {
    private final HotelServiceImpl hotelService;

    @PostMapping("/save_hotel")
    private ResponseEntity<HotelEntity> saveHotel(@RequestBody HotelModel hotelModel) {
        return ResponseEntity.ok(hotelService.save(hotelModel));
    }

    @GetMapping("/{id}")
    private ResponseEntity<HotelDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(hotelService.findById(id));
    }

    @GetMapping("/get_all_hoteles")
    private ResponseEntity<List<HotelDTO>> findAll() {
        return ResponseEntity.ok(hotelService.findAll());
    }

    @PutMapping("/update_hotel")
    private ResponseEntity<HotelEntity> updateHotel(@RequestBody HotelModel hotelModel) {
        return ResponseEntity.ok(hotelService.update(hotelModel));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        hotelService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
