package com.hostel.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class ApartmentTest {

	@Test
    void testApartmentHasSevenRooms() {
        Apartment apartment = new Apartment("A");
        assertEquals(9, apartment.getRoomCount(), "Apartment A should have 7 rooms");
}
	
	@ParameterizedTest
    @ValueSource(strings = {"A", "B", "C", "D", "E"})
    void testApartmentRoomIds(String apartmentId) {
        Apartment apartment = new Apartment(apartmentId);

        // Check first room ID
        assertEquals(apartmentId + "1", apartment.getRooms().get(0).getRoomId());

        // Check last room ID
        assertEquals(apartmentId + "7", apartment.getRooms().get(6).getRoomId());
    }
}