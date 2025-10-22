package com.hostel.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ApartmentTest {

	@Test
    void testApartmentHasSevenRooms() {
        Apartment apartment = new Apartment("A");
        assertEquals(7, apartment.getRoomCount(), "Apartment A should have 7 rooms");

}
}