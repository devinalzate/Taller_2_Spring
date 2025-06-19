package co.edu.udistrital.taller2.controller;

import co.edu.udistrital.taller2.Models.UserModel;
import co.edu.udistrital.taller2.dtos.UserDTO;
import co.edu.udistrital.taller2.entitys.UserEntity;
import co.edu.udistrital.taller2.services.UserServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
