package com.afam.cocodeapi.Services;

import com.afam.cocodeapi.Enums.RoomStatus;
import com.afam.cocodeapi.Models.RoomModel;
import com.afam.cocodeapi.Repositories.RoomRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    public List<RoomModel> getAllRooms() {
        return roomRepository.findAll();
    }

    public RoomModel getOneRoom(Long roomId) {
        Optional<RoomModel> RoomModelOptional = roomRepository.findById(roomId);

        if (RoomModelOptional.isEmpty()) {
            throw new EntityNotFoundException("The room with id: " + roomId + " cannot be found");
        }

        return RoomModelOptional.get();
    }
    public RoomModel createRoom(String roomName, String passcode) {
        Optional<RoomModel> RoomModelOptional = roomRepository.findByRoomName(roomName);

        if (RoomModelOptional.isPresent()) {
            throw new IllegalStateException("The room you are attempting to create already exists");
        }

        return new RoomModel(roomName, passcode, List.of(1), RoomStatus.In_Use);

    }
    
}
