package com.afam.cocodeapi.Models;

import com.afam.cocodeapi.Enums.RoomType;
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
    private String roomPasscode;
    private List<Integer> userCount;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    public RoomModel() {
    }

    public RoomModel(long id, String roomName, String roomPasscode, List<Integer> userCount, RoomType roomType) {
        this.id = id;
        this.roomName = roomName;
        this.roomPasscode = roomPasscode;
        this.userCount = userCount;
        this.roomType = roomType;
    }

    public RoomModel(String roomName, String roomPasscode, List<Integer> userCount, RoomType roomType) {
        this.roomName = roomName;
        this.roomPasscode = roomPasscode;
        this.userCount = userCount;
        this.roomType = roomType;
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

    public String getRoomPasscode() {
        return roomPasscode;
    }

    public void setRoomPasscode(String roomPasscode) {
        this.roomPasscode = roomPasscode;
    }

    public List<Integer> getUserCount() {
        return userCount;
    }

    public void setUserCount(List<Integer> userCount) {
        this.userCount = userCount;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "RoomModel{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", roomPasscode='" + roomPasscode + '\'' +
                ", userCount=" + userCount +
                ", roomType=" + roomType +
                '}';
    }
}