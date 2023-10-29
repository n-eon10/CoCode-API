package com.afam.cocodeapi.Repositories;

import com.afam.cocodeapi.Models.RoomModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<RoomModel, Long> {
    @Query("SELECT CASE WHEN COUNT(room) > 0 THEN true ELSE false END FROM RoomModel room WHERE room.roomName = ?1")
    boolean existsByRoomName(String roomName);

    @Query("SELECT room FROM RoomModel room WHERE room.roomName = ?1")
    Optional<RoomModel> findByRoomName(String roomName);
}