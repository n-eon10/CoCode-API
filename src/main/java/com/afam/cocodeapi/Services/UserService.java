package com.afam.cocodeapi.Services;

import com.afam.cocodeapi.Models.UserModel;
import com.afam.cocodeapi.Repositories.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    private String generateToken(String username) {
        String secretKey = environment.getProperty("SECRET");

        long expiration = System.currentTimeMillis() + 604800000;

        return "token: " + Jwts.builder().setSubject(username)
                .setExpiration(new Date(expiration))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }


    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel getOneUser(Long userId) {
        Optional<UserModel> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()) {
            throw new EntityNotFoundException("The user with id: " + userId + " does not currently exist");
        }

        return userOptional.get();
    }

    public UserModel createUser(UserModel user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalStateException("The email you are attempting to register already exists");
        }

        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalStateException("The username you are attempting to register already exists");
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String hashedPassword = passwordEncoder.encode(user.getPassword());


        user.setPassword(hashedPassword);

        System.out.println(user);

        userRepository.save(user);

        return user;
    }

    public UserModel loginUser(String email, String password) {
        Optional<UserModel> userModelOptional = userRepository.findByEmail(email);

        if (userModelOptional.isEmpty()) {
            throw new EntityNotFoundException("The user with email: " + email + " cannot be found");
        }

        UserModel user = userModelOptional.get();

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches(password, user.getPassword())) {


            return user;
        } else {
            throw new IllegalStateException("You have entered an incorrect password please try again");
        }

    }


}
