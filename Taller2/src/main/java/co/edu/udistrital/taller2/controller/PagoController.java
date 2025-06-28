package co.edu.udistrital.taller2.controller;

import co.edu.udistrital.taller2.Models.PagoModel;
import co.edu.udistrital.taller2.dtos.PagoDTO;
import co.edu.udistrital.taller2.dtos.ReservaDTO;
import co.edu.udistrital.taller2.entitys.PagoEntity;
import co.edu.udistrital.taller2.services.PagoServiceImpl;
import co.edu.udistrital.taller2.services.ReservaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//
@RestController
@RequestMapping("/api/v1/pagos")
public class PagoController {

    @Autowired
    private PagoServiceImpl pagoService;

    @Autowired
    private ReservaServiceImpl reservaService;

    @PostMapping("/save_pago")
    private ResponseEntity<PagoEntity> savePago(@RequestBody PagoModel pago) {
        return ResponseEntity.ok(pagoService.save(pago));
    }

    @GetMapping("/find_all_pagos")
    private ResponseEntity<List<PagoDTO>> findAllPagos() {
        return ResponseEntity.ok(pagoService.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<PagoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(pagoService.findById(id));
    }

    @GetMapping("/reserva/{id}")
    private ResponseEntity<ReservaDTO> getReserva(@PathVariable Long id) {
        PagoDTO pagoDTO = pagoService.findById(id);
        if (pagoDTO == null || pagoDTO.getFk_id_reserva() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reservaService.findById(pagoDTO.getFk_id_reserva().longValue()));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deletePago(@PathVariable Long id) {
        pagoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update_pago")
    private ResponseEntity<PagoEntity> updatePago(@RequestBody PagoModel pago) {
        return ResponseEntity.ok(pagoService.update(pago));
    }
}