package com.afam.cocodeapi.Controllers;

import com.afam.cocodeapi.Models.RoomModel;
import com.afam.cocodeapi.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/rooms")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(path = "/getall")
    public ResponseEntity<?> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping(path = "/getone/{roomid}")
    public ResponseEntity<?> getOneRoom(@PathVariable Long roomId) {
        return roomService.getOneRoom(roomId);
    }

    @PostMapping(path = "/createroom")
    public ResponseEntity<?> createRoom(@RequestBody RoomModel room) {
        return roomService.createRoom(room);
    }

    @PostMapping(path = "/joinroom")
    public ResponseEntity<?> joinRoom(@RequestBody Map<String, String> credentials) {
        return roomService.joinRoom(credentials);
    }


}