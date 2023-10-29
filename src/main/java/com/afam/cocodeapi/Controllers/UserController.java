package com.afam.cocodeapi.Controllers;

import com.afam.cocodeapi.Models.UserModel;
import com.afam.cocodeapi.Services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/getall")
    public ResponseEntity<?> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/getone/{userId}")
    public ResponseEntity<?> getOneUser(@PathVariable Long userId) {
        return userService.getOneUser(userId);
    }

    @PostMapping(path = "/createuser")
    public ResponseEntity<?> createUser(@RequestBody UserModel user) {
        return userService.createUser(user);
    }

    @PostMapping(path = "/loginuser")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> credentials) {
        return userService.loginUser(credentials);
    }



}
