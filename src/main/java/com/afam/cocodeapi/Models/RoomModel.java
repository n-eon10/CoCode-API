package com.afam.cocodeapi.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rooms")
public class RoomModel {
    @Id
    @SequenceGenerator(
            name = "room_sequence",
            sequenceName = "room_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "room_sequence"
    )
    private long id;
    private String roomName;
    private List<UserModel> roomUsers;
    private String roomStatus;

    public RoomModel() {
    }

    public RoomModel(long id, String roomName, List<UserModel> roomUsers, String roomStatus) {
        this.id = id;
        this.roomName = roomName;
        this.roomUsers = roomUsers;
        this.roomStatus = roomStatus;
    }

    public RoomModel(String roomName, List<UserModel> roomUsers, String roomStatus) {
        this.roomName = roomName;
        this.roomUsers = roomUsers;
        this.roomStatus = roomStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public List<UserModel> getRoomUsers() {
        return roomUsers;
    }

    public void setRoomUsers(List<UserModel> roomUsers) {
        this.roomUsers = roomUsers;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }
}
