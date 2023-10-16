package com.afam.cocodeapi.Controllers;

import com.afam.cocodeapi.Models.RoomModel;
import com.afam.cocodeapi.Services.RoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(path = "/getall")
    public List<RoomModel> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping(path = "/getone/{roomid}")
    public RoomModel getOneRoom(Long roomId) {
        return roomService.getOneRoom(roomId);
    }
    
}
