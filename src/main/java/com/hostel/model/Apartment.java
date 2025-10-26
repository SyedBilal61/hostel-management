package com.hostel.model;
import java.util.ArrayList;
import java.util.List;

public class Apartment {
    private String apartmentId;
    private List<Room> rooms;
    public Apartment(String apartmentId) {
        this.apartmentId = apartmentId;
        this.rooms = new ArrayList<>();

        // create 7 rooms for each apartment
        for (int i = 1; i <= 7; i++) {
            rooms.add(new Room(apartmentId + i));
        }
    }
    public String getApartmentId() {
        return apartmentId;
    }
    public List<Room> getRooms() {
        return rooms;
    }
    public int getRoomCount() {
        return rooms.size();
    }
    // try to book a room by its ID
    public boolean bookRoom(String roomId) {
        for (Room room : rooms) {
            if (room.getRoomId().equals(roomId)) {
                if (!room.isEmpty()) {
                    return false; // already booked
                }
                room.book();
                return true; // booking successful
            }
        }
        return false; // room not found
    }
    // try to cancel booking by room ID
    public boolean cancelBooking(String roomId) {
        for (Room room : rooms) {
            if (room.getRoomId().equals(roomId)) {
                if (!room.isEmpty()) {
                    room.cancelBooking();
                    return true; // cancellation successful
                } else {
                    return false; // room was already empty
                }
            }
        }
        return false; // room not found
    }

    // get all currently available rooms
    public List<Room> getAvailableRooms() {
        List<Room> available = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isEmpty()) {
                available.add(room);
            }
        }
        return available;
    }
    public List<Room> getBookedRooms() {
        List<Room> booked = new ArrayList<>();
        for (Room room : rooms) {
            if (!room.isEmpty()) {  // if room is booked
                booked.add(room);
            }
        }
        return booked;
    }

}
