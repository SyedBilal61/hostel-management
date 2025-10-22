package com.hostel.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {
	
		@Test
	    void testRoomInitiallyEmpty() {
	        Room room = new Room(101);
	        assertTrue(room.isEmpty(), "Room should start empty");
	    }

}
