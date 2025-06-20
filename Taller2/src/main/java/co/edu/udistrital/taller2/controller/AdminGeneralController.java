package co.edu.udistrital.taller2.controller;

import co.edu.udistrital.taller2.Models.AdminGeneralModel;
import co.edu.udistrital.taller2.dtos.AdminGeneralDTO;
import co.edu.udistrital.taller2.entitys.AdminGeneralEntity;
import co.edu.udistrital.taller2.repos.AdminGeneralRepository;
import co.edu.udistrital.taller2.services.AdminGeneralServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin_general")
@RequiredArgsConstructor
public class AdminGeneralController {

    private final AdminGeneralServiceImpl adminGeneralService;

    @PostMapping("/save_admin_general")
    private ResponseEntity<AdminGeneralEntity> saveAdminGeneral(@RequestBody AdminGeneralModel adminGeneralModel) {
        return ResponseEntity.ok(adminGeneralService.save(adminGeneralModel));
    }

    @GetMapping("/{id}")
    private ResponseEntity<AdminGeneralDTO> findAdminGeneralById(@PathVariable Long id) {
        return ResponseEntity.ok(adminGeneralService.findById(id));
    }

    @GetMapping("/get_all")
    private ResponseEntity<List<AdminGeneralDTO>> findAllAdminGeneral() {
        return ResponseEntity.ok(adminGeneralService.findAll());
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteAllAdminGeneral(@PathVariable Long id) {
        adminGeneralService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update_admin_general")
    private ResponseEntity<AdminGeneralEntity> updateAdminGeneral(@RequestBody AdminGeneralModel adminGeneralModel) {
        return ResponseEntity.ok(adminGeneralService.update(adminGeneralModel));
    }
}
