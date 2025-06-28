package co.edu.udistrital.taller2.controller;

import co.edu.udistrital.taller2.Models.FacturaModel;
import co.edu.udistrital.taller2.dtos.FacturaDTO;
import co.edu.udistrital.taller2.dtos.PagoDTO;
import co.edu.udistrital.taller2.dtos.ReservaDTO;
import co.edu.udistrital.taller2.entitys.FacturaEntity;
import co.edu.udistrital.taller2.services.FacturaServiceImpl;
import co.edu.udistrital.taller2.services.PagoServiceImpl;
import co.edu.udistrital.taller2.services.ReservaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/facturas")
public class FacturaController {

    @Autowired
    private FacturaServiceImpl facturaService;

    @Autowired
    private ReservaServiceImpl reservaService;

    @Autowired
    private PagoServiceImpl pagoService;

    @PostMapping("/save_factura")
    private ResponseEntity<FacturaEntity> saveFactura(@RequestBody FacturaModel factura) {
        return ResponseEntity.ok(facturaService.save(factura));
    }

    @GetMapping("/find_all_facturas")
    private ResponseEntity<List<FacturaDTO>> findAllFacturas() {
        return ResponseEntity.ok(facturaService.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<FacturaDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(facturaService.findById(id));
    }

    @GetMapping("/reserva/{id}")
    private ResponseEntity<ReservaDTO> getReserva(@PathVariable Long id) {
        FacturaDTO facturaDTO = facturaService.findById(id);
        if (facturaDTO == null || facturaDTO.getFk_id_reserva() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reservaService.findById(facturaDTO.getFk_id_reserva().longValue()));
    }

    @GetMapping("/pago/{id}")
    private ResponseEntity<PagoDTO> getPago(@PathVariable Long id) {
        FacturaDTO facturaDTO = facturaService.findById(id);
        if (facturaDTO == null || facturaDTO.getFk_id_pago() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pagoService.findById(facturaDTO.getFk_id_pago().longValue()));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteFactura(@PathVariable Long id) {
        facturaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update_factura")
    private ResponseEntity<FacturaEntity> updateFactura(@RequestBody FacturaModel factura) {
        return ResponseEntity.ok(facturaService.update(factura));
    }
}