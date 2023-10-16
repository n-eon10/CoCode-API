package com.afam.cocodeapi.Controllers;

import com.afam.cocodeapi.Models.RoomModel;
import com.afam.cocodeapi.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/rooms")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(path = "/getall")
    public List<RoomModel> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping(path = "/getone/{roomid}")
    public RoomModel getOneRoom(@PathVariable Long roomId) {
        return roomService.getOneRoom(roomId);
    }
    
}
