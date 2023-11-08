package com.afam.cocodeapi.Services;

import com.afam.cocodeapi.Enums.RoomType;
import com.afam.cocodeapi.Models.RoomModel;
import com.afam.cocodeapi.Repositories.RoomRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final Environment environment;

    @Autowired
    public RoomService(RoomRepository roomRepository, Environment environment) {
        this.roomRepository = roomRepository;
        this.environment = environment;
    }

    private String generateToken(String subject) {
        String secretKey = environment.getProperty("SECRET");

        long expiration = System.currentTimeMillis() + 604800000;

        return  Jwts.builder().setSubject(subject)
                .setExpiration(new Date(expiration))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public ResponseEntity<?> getAllRooms() {
        List<RoomModel> rooms = roomRepository.findAll();
        return ResponseEntity.ok(rooms);
    }

    public ResponseEntity<?> getOneRoom(Long roomId) {
        Optional<RoomModel> roomOptional = roomRepository.findById(roomId);

        if (roomOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The room you are looking for does not exist");
        }

        RoomModel room = roomOptional.get();
        return ResponseEntity.ok(room);
    }

    public ResponseEntity<?> createRoom(RoomModel room) {
        if (roomRepository.existsByRoomName(room.getRoomName())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The room with room name: " + "room name already exists");
        }

        String token = generateToken(room.getRoomName());

        Map<String, Object> response = new HashMap<>();

        roomRepository.save(room);

        response.put("token", token);
        response.put("room", room);


        return ResponseEntity.ok(response);
    }

    public ResponseEntity<?> joinRoom(Map<String, String> credentials) {
        String roomName = credentials.get("roomname");
        String password = credentials.get("password");

        Optional<RoomModel> roomOptional = roomRepository.findByRoomName(roomName);

        if (roomOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The room you are attempting to join cannot be found");
        }

        RoomModel room = roomOptional.get();

        if (room.getRoomType() == RoomType.Private) {
            if (!Objects.equals(password, room.getRoomPasscode())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect Password");
            }
        }

        String token = generateToken(room.getRoomName());

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("room", room);

        return ResponseEntity.ok(response);
    }
}