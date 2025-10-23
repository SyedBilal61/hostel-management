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
        room.book();
        assertFalse(room.isEmpty());
    }

    @Test
    void canCancelBooking() {
        Room room = new Room("A6");
        room.book();
        room.cancelBooking();
        assertTrue(room.isEmpty());
    }
}
