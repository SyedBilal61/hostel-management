package com.hostel.practice;

import com.hostel.model.Apartment;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ApartmentExceptionPracticeTest {

    @Test
    void bookingNonExistentRoomThrowsException() {
        Apartment apartment = new Apartment("A");
        ApartmentExceptionPractice practice = new ApartmentExceptionPractice(apartment);

        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> practice.bookRoom("A99")); // non-existent room

        assertEquals("Room A99 does not exist", exception.getMessage());
    }
}
