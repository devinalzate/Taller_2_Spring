package co.edu.udistrital.taller2.controller;


import co.edu.udistrital.taller2.Models.AdminModel;
import co.edu.udistrital.taller2.dtos.AdminDTO;
import co.edu.udistrital.taller2.entitys.AdminEntity;
import co.edu.udistrital.taller2.repos.AdminRepository;
import co.edu.udistrital.taller2.services.AdminServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admins")
@RequiredArgsConstructor
public class AdminController {

    private final AdminServiceImpl adminService;

    @PostMapping("/save_admin")
    private ResponseEntity<AdminEntity> saveAdmin(@RequestBody AdminModel model) {
        return ResponseEntity.ok(adminService.save(model));
    }

    @PutMapping("/update_admin")
    private ResponseEntity<AdminEntity> updateAdmin(@RequestBody AdminModel model) {
        return ResponseEntity.ok(adminService.update(model));
    }

    @GetMapping("/get_admins")
    private ResponseEntity<List<AdminDTO>> getAdmins() {
        return ResponseEntity.ok(adminService.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<AdminDTO> getAdmin(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.findById(id));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        adminService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
