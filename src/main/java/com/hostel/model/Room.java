package com.hostel.model;

public class Room {
    private final String roomId;
    private boolean empty;  // true if room is empty, false if booked

    public Room(String roomId) {
        this.roomId = roomId;
        this.empty = true; // room starts empty
    }

    public String getRoomId() {
        return roomId;
    }

    public boolean isEmpty() {
        return empty;
    }

    /**
     * Attempts to book the room.
     * @return true if booking succeeds, false if already booked
     */
    public boolean book() {
        if (!empty) {
            return false; // already booked
        }
        empty = false;
        return true;
    }

    /**
     * Cancels the booking, making the room empty again.
     */
    public void cancelBooking() {
        empty = true;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId='" + roomId + '\'' +
                ", empty=" + empty +
                '}';
    }
}
