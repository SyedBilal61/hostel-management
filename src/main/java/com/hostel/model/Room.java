package com.hostel.model;

public class Room {
    private String roomId;
    private boolean empty;

    public Room(String roomId) {
        this.roomId = roomId;
        this.empty = true; 
    }
    public String getRoomId() {
        return roomId;
    }
    public boolean isEmpty() {
        return empty;
    }
    public void book() {
        empty = false;
    }
    public void cancelBooking() {
        empty = true;
    }

}