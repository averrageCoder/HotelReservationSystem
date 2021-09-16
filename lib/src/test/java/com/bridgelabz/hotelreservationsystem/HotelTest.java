package com.bridgelabz.hotelreservationsystem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class HotelTest {

	@Test
	public void givenHotelName_shouldReturnProperHotelName(){
		MainSystem hotelReservationSystem = new MainSystem();
		hotelReservationSystem.addHotel("bridge", 100);
		ArrayList<Hotel> hotelList = hotelReservationSystem.getHotelList();
		assertEquals("bridge", hotelList.get(0).getHotelName());
	}
	
	@Test
	public void givenHotelRate_shouldReturnProperHotelRate() throws Exception {
		MainSystem hotelReservationSystem = new MainSystem();
		hotelReservationSystem.addHotel("bridge", 100);
		ArrayList<Hotel> hotelList = hotelReservationSystem.getHotelList();
		assertEquals(100, hotelList.get(0).getRateForRegularCustomer());
	}
	
	@Test
	public void givenHotelList_shouldReturnProperSize() throws Exception {
		MainSystem hotelReservationSystem = new MainSystem();
		hotelReservationSystem.addHotel("bridge", 100);
		ArrayList<Hotel> hotelList = hotelReservationSystem.getHotelList();
		assertEquals(1, hotelList.size());
	}
	
}
