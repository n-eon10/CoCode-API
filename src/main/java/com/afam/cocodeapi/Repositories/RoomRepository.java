package com.afam.cocodeapi.Repositories;

import com.afam.cocodeapi.Models.RoomModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<RoomModel, Long> {

    @Query("SELECT room FROM RoomRepository room WHERE room.roomname = ?1")
    Optional<RoomModel> findByRoomName(String roomName);
}
