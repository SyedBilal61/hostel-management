package com.hostel.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {

    @Test
    void roomShouldBeEmptyInitially() {
        Room room = new Room("A6");
        assertTrue(room.isEmpty());
    }

    @Test
    void canBookRoom() {
        Room room = new Room("A6");
        boolean result = room.book();
        System.out.println(room); // 👈 this line prints using toString(), 
        assertTrue(result, "Expected book() to return true when booking an empty room");
        assertFalse(room.isEmpty());
    }

    @Test
    void canCancelBooking() {
        Room room = new Room("A6");
        room.book();
        room.cancelBooking();
        assertTrue(room.isEmpty());
    }
    @Test
    void bookingAlreadyBookedRoomReturnsFalse() {
        Room room = new Room("A6");
        room.book(); // first booking succeeds
        assertFalse(room.book()); // second booking should return false
    }

    

}
