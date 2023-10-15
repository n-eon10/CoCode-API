package com.afam.cocodeapi.Controllers;

import com.afam.cocodeapi.Models.UserModel;
import com.afam.cocodeapi.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/getall")
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/getone/{userId}")
    public UserModel getOneUser(@PathVariable Long userId) {
        return userService.getOneUser(userId);
    }

    @PostMapping(path = "/createuser")
    public UserModel createUser(@RequestBody String username,
                                String email,
                                String password) {
        return userService.createUser(username, email, password);
    }

    @PostMapping(path = "/login")
    public UserModel loginUser(@RequestBody String email,
                               String password) {
        return userService.loginUser(email, password);
    }



}
