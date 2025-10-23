package com.hostel.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ApartmentTest {

    @Test
    void apartmentShouldHaveSevenRooms() {
        Apartment apartment = new Apartment("A");
        assertEquals(7, apartment.getRoomCount());
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "B", "C", "D", "E"})
    void roomIdsShouldBeCorrect(String apartmentId) {
        Apartment apartment = new Apartment(apartmentId);

        assertEquals(apartmentId + "1", apartment.getRooms().get(0).getRoomId());
        assertEquals(apartmentId + "7", apartment.getRooms().get(6).getRoomId());
    }

    @Test
    void canBookAnAvailableRoom() {
        Apartment apartment = new Apartment("A");
        boolean booked = apartment.bookRoom("A1");

        assertTrue(booked);
        assertFalse(apartment.getRooms().get(0).isEmpty());
    }

    @Test
    void cannotBookAlreadyBookedRoom() {
        Apartment apartment = new Apartment("A");
        apartment.bookRoom("A1");
        boolean bookedAgain = apartment.bookRoom("A1");

        assertFalse(bookedAgain);
    }

    @Test
    void cannotBookNonExistentRoom() {
        Apartment apartment = new Apartment("A");
        boolean booked = apartment.bookRoom("A99");

        assertFalse(booked);
    }

    @Test
    void canCancelABookedRoom() {
        Apartment apartment = new Apartment("A");

        apartment.bookRoom("A1");
        boolean cancelled = apartment.cancelBooking("A1");

        assertTrue(cancelled);
        assertTrue(apartment.getRooms().get(0).isEmpty());
    }

    @Test
    void cannotCancelAnEmptyRoom() {
        Apartment apartment = new Apartment("A");

        boolean cancelled = apartment.cancelBooking("A1");

        assertFalse(cancelled);
    }

    @Test
    void getAvailableRoomsShouldReturnCorrectCount() {
        Apartment apartment = new Apartment("A");
        apartment.bookRoom("A1");
        apartment.bookRoom("A2");

        List<Room> available = apartment.getAvailableRooms();
        assertEquals(5, available.size());
        assertTrue(available.stream().noneMatch(r -> r.getRoomId().equals("A1")));
        assertTrue(available.stream().noneMatch(r -> r.getRoomId().equals("A2")));
    }
    @Test
    void testGetBookedRooms() {
        Apartment apartment = new Apartment("A");

        // Book a few rooms
        apartment.bookRoom("A1");
        apartment.bookRoom("A3");

        // Get booked rooms
        List<Room> bookedRooms = apartment.getBookedRooms();

        // Verify
        assertEquals(2, bookedRooms.size(), "There should be 2 booked rooms");
        assertTrue(bookedRooms.stream().anyMatch(r -> r.getRoomId().equals("A1")));
        assertTrue(bookedRooms.stream().anyMatch(r -> r.getRoomId().equals("A3")));
    }

}
