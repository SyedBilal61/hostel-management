package com.hostel.practice;

import com.hostel.model.Apartment;

public class ApartmentExceptionPractice {

    private final Apartment apartment;

    public ApartmentExceptionPractice(Apartment apartment) {
        this.apartment = apartment;
    }

    public void bookRoom(String roomId) {
        if (!apartment.getRooms().stream().anyMatch(r -> r.getRoomId().equals(roomId))) {
            throw new IllegalArgumentException("Room " + roomId + " does not exist");
        }
        apartment.bookRoom(roomId);
    }
}
