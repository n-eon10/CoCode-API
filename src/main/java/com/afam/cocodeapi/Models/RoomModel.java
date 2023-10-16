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
    private String roomPasscode;
    private List<Integer> userCount;
    private String roomStatus;

    public RoomModel() {
    }

    public RoomModel(long id, String roomName, String passcode, List<Integer> userCount, String roomStatus) {
        this.id = id;
        this.roomName = roomName;
        roomPasscode = passcode;
        this.userCount = userCount;
        this.roomStatus = roomStatus;
    }

    public RoomModel(String roomName, String passcode, List<Integer> userCount, String roomStatus) {
        this.roomName = roomName;
        roomPasscode = passcode;
        this.userCount = userCount;
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

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    @Override
    public String toString() {
        return "RoomModel{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", userCount=" + userCount +
                ", roomStatus='" + roomStatus + '\'' +
                '}';
    }
}
