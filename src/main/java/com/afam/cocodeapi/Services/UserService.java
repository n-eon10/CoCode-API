package com.afam.cocodeapi.Services;

import com.afam.cocodeapi.Models.UserModel;
import com.afam.cocodeapi.Repositories.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final Environment environment;

    @Autowired
    public UserService(UserRepository userRepository,
                       Environment environment) {
        this.userRepository = userRepository;
        this.environment = environment;
    }

    private String generateToken(String subject) {
        String secretKey = environment.getProperty("SECRET");

        long expiration = System.currentTimeMillis() + 604800000;

        return "token: " + Jwts.builder().setSubject(subject)
                .setExpiration(new Date(expiration))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }


    public ResponseEntity<?> getAllUsers() {
        List<UserModel> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    public ResponseEntity<?> getOneUser(Long userId) {
        Optional<UserModel> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not exist.");
        }

        UserModel user = userOptional.get();
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<?> createUser(UserModel user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The email you are attempting to register already exists");
        }

        if (userRepository.existsByUsername(user.getUsername())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The username you are attempting to register already exists");
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(user); // Return 201 Created status with the created user.
    }

    public ResponseEntity<?> loginUser(Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            return ResponseEntity.badRequest().body("Please enter a valid email and password.");
        }

        Optional<UserModel> userOptional = userRepository.findByEmail(email);

        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not exist.");
        }

        UserModel user = userOptional.get();

        if (user.getPassword() != null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if (!passwordEncoder.matches(password, user.getPassword())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect password.");
            }
        }

        String token = generateToken(user.getEmail());

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("user", user);

        return ResponseEntity.ok(response);
    }

}
