package com.bridgelabz.hotelreservationsystem;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;
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
	public void givenHotelRate_shouldReturnProperHotelRate(){
		MainSystem hotelReservationSystem = new MainSystem();
		hotelReservationSystem.addHotel("bridge", 100);
		ArrayList<Hotel> hotelList = hotelReservationSystem.getHotelList();
		assertEquals(100, hotelList.get(0).getRateForRegularCustomer());
	}
	
	@Test
	public void givenHotelList_shouldReturnProperSize() {
		MainSystem hotelReservationSystem = new MainSystem();
		hotelReservationSystem.addHotel("bridge", 100);
		ArrayList<Hotel> hotelList = hotelReservationSystem.getHotelList();
		assertEquals(1, hotelList.size());
	}
	
	@Test
	public void givenHotelList_shouldReturnCheapestHotel(){
		MainSystem hotelReservationSystem = new MainSystem();
		hotelReservationSystem.addHotel("bridge", 100);
		hotelReservationSystem.addHotel("lakeview", 10);
		LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 10);    
		LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 11);    
		Hotel hotel = hotelReservationSystem.getCheapestHotel(startDate, endDate);
		assertEquals(10, hotel.getRateForRegularCustomer());
	}
	
}
