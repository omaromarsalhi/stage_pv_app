package com.stage.insertMarks.controller;

import com.stage.insertMarks.dto.UserDto;
import com.stage.insertMarks.entity.User;
import com.stage.insertMarks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000/")
public class UserController {

    @Autowired
    private UserService userService;

    // Get all users
    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get user by ID
    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/{idUser}")
    public ResponseEntity<User> getUserById(@PathVariable Integer idUser) {
        Optional<User> user = userService.getUserById(idUser);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get user by email
    @GetMapping("/email")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        Optional<User> user = userService.getUserByEmail(email);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/identifier")
    public ResponseEntity<User> getUserByIdentifier(@RequestParam String identifier) {
        Optional<User> user = userService.getUserByIdentifier(identifier);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping("/students/{idGrade}")
    public ResponseEntity<List<UserDto>> getUsers(
            @PathVariable("idGrade") int idGrade
    ) {
        return ResponseEntity.ok(userService.getStudents(idGrade));
    }
}
