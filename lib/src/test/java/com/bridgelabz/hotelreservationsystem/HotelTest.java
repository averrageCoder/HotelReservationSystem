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
		hotelReservationSystem.addHotel("bridge", 100, 150);
		ArrayList<Hotel> hotelList = hotelReservationSystem.getHotelList();
		assertEquals("bridge", hotelList.get(0).getHotelName());
	}
	
	@Test
	public void givenHotelRate_shouldReturnProperHotelWeedDayRate(){
		MainSystem hotelReservationSystem = new MainSystem();
		hotelReservationSystem.addHotel("bridge", 100, 150);
		ArrayList<Hotel> hotelList = hotelReservationSystem.getHotelList();
		assertEquals(100, hotelList.get(0).getRateForWeekDay());
	}
	
	@Test
	public void givenHotelRate_shouldReturnProperHotelWeedEndRate(){
		MainSystem hotelReservationSystem = new MainSystem();
		hotelReservationSystem.addHotel("bridge", 100, 150);
		ArrayList<Hotel> hotelList = hotelReservationSystem.getHotelList();
		assertEquals(150, hotelList.get(0).getRateForWeekEnd());
	}
	
	@Test
	public void givenHotelList_shouldReturnProperSize() {
		MainSystem hotelReservationSystem = new MainSystem();
		hotelReservationSystem.addHotel("bridge", 100, 150);
		ArrayList<Hotel> hotelList = hotelReservationSystem.getHotelList();
		assertEquals(1, hotelList.size());
	}
	
	@Test
	public void givenHotelList_shouldReturnCheapestHotel(){
		MainSystem hotelReservationSystem = new MainSystem();
		hotelReservationSystem.addHotel("bridgewood", 150, 50);
		hotelReservationSystem.addHotel("lakeview", 110, 90);
		hotelReservationSystem.addHotel("ridgewood", 220, 150);
		LocalDate startDate = LocalDate.of(2020, Month.SEPTEMBER, 11);    
		LocalDate endDate = LocalDate.of(2020, Month.SEPTEMBER, 12);    
		double totalRate = hotelReservationSystem.getCheapestHotel(startDate, endDate);
		assertEquals(160, totalRate);
	}
	
}
