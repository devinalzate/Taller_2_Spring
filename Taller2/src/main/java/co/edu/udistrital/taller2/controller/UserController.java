package co.edu.udistrital.taller2.controller;

import co.edu.udistrital.taller2.Models.UserModel;
import co.edu.udistrital.taller2.dtos.AdminDTO;
import co.edu.udistrital.taller2.dtos.AdminGeneralDTO;
import co.edu.udistrital.taller2.dtos.ClienteDTO;
import co.edu.udistrital.taller2.dtos.EmpleadoDTO;
import co.edu.udistrital.taller2.dtos.UserDTO;
import co.edu.udistrital.taller2.entitys.UserEntity;
import co.edu.udistrital.taller2.services.UserServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserServicesImpl userService;

    @PostMapping("/save_user")
    private ResponseEntity<UserEntity> saveUser(@RequestBody UserModel user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/find_all_users")
    private ResponseEntity<List<UserDTO>> findAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/empleado/{id}")
    private ResponseEntity<EmpleadoDTO> getEmpleado(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getFkEmployeeById(id));
    }

    @GetMapping("/admin/{id}")
    private ResponseEntity<AdminDTO> getAdmin(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getFkAdminById(id));
    }

    @GetMapping("/admin_general/{id}")
    private ResponseEntity<AdminGeneralDTO> getAdminGeneral(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getFkAdminGeneralById(id));
    }

    @GetMapping("/cliente/{id}")
    private ResponseEntity<ClienteDTO> getCliente(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getFkClienteById(id));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update_user")
    private ResponseEntity<UserEntity> updateUser(@RequestBody UserModel user) {
        return ResponseEntity.ok(userService.update(user));
    }
}
