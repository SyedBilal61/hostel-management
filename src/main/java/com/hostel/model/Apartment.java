package com.hostel.model;

import java.util.ArrayList;
import java.util.List;

public class Apartment {
	private String apartmentId;
	private List<Room> rooms;
	
	public Apartment(String apartmentId) {
        this.apartmentId = apartmentId;
        this.rooms = new ArrayList<>();
        
        for (int i = 1; i <= 7; i++) {
            rooms.add(new Room(apartmentId + i));
        }
    }
	public int getRoomCount() {
        return rooms.size();
    }
	
    public String getApartmentId() {
        return apartmentId;
    }
    public List<Room> getRooms() {
        return rooms;
    }   
 // TDD: minimal implementation to satisfy testBookAvailableRoom
    public boolean bookRoom(String roomId) {
        for (Room room : rooms) {
            if (room.getRoomId().equals(roomId)) {
                if (!room.isEmpty()) {
                    return true; // already booked
                }
                room.book();
                return true;
            }
        }
        return false; // room not found
    }
}
