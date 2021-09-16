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
		hotelReservationSystem.addHotel("bridge", 100, 150, 110, 150, 3);
		ArrayList<Hotel> hotelList = hotelReservationSystem.getHotelList();
		assertEquals("bridge", hotelList.get(0).getHotelName());
	}
	
	@Test
	public void givenHotelRate_shouldReturnProperHotelWeekDayRate(){
		MainSystem hotelReservationSystem = new MainSystem();
		hotelReservationSystem.addHotel("bridge", 100, 150, 110, 150, 3);
		ArrayList<Hotel> hotelList = hotelReservationSystem.getHotelList();
		assertEquals(100, hotelList.get(0).getRateForWeekDayForRegularCustomer());
	}
	
	@Test
	public void givenHotelRate_shouldReturnProperHotelWeekdEndRate(){
		MainSystem hotelReservationSystem = new MainSystem();
		hotelReservationSystem.addHotel("bridge", 100, 150, 110, 150, 3);
		ArrayList<Hotel> hotelList = hotelReservationSystem.getHotelList();
		assertEquals(150, hotelList.get(0).getRateForWeekEndForRegularCustomer());
	}
	
	@Test
	public void givenHotelRate_shouldReturnProperHotelWeekDayRateForRewardCustomer(){
		MainSystem hotelReservationSystem = new MainSystem();
		hotelReservationSystem.addHotel("bridge", 100, 150, 110, 150, 3);
		ArrayList<Hotel> hotelList = hotelReservationSystem.getHotelList();
		assertEquals(110, hotelList.get(0).getRateForWeekDayForRewardCustomer());
	}
	
	@Test
	public void givenHotelRate_shouldReturnProperHotelWeekdEndRateForRewardCustomer(){
		MainSystem hotelReservationSystem = new MainSystem();
		hotelReservationSystem.addHotel("bridge", 100, 150, 110, 150, 3);
		ArrayList<Hotel> hotelList = hotelReservationSystem.getHotelList();
		assertEquals(150, hotelList.get(0).getRateForWeekEndForRewardCustomer());
	}
	
	@Test
	public void givenHotel_shouldReturnProperHotelRating(){
		MainSystem hotelReservationSystem = new MainSystem();
		hotelReservationSystem.addHotel("bridge", 100, 150, 110, 150, 3);
		ArrayList<Hotel> hotelList = hotelReservationSystem.getHotelList();
		assertEquals(3, hotelList.get(0).getRatings());
	}
	
	@Test
	public void givenHotelList_shouldReturnProperSize() {
		MainSystem hotelReservationSystem = new MainSystem();
		hotelReservationSystem.addHotel("bridge", 100, 150, 110, 150, 3);
		ArrayList<Hotel> hotelList = hotelReservationSystem.getHotelList();
		assertEquals(1, hotelList.size());
	}
	
	
	
	@Test
	public void givenHotelList_shouldReturnCheapestHotelBasedOnWeekdayAndWeekend(){
		MainSystem hotelReservationSystem = new MainSystem();
		hotelReservationSystem.addHotel("bridgewood", 150, 50, 110, 150, 3);
		hotelReservationSystem.addHotel("lakeview", 110, 90,110, 150, 4);
		hotelReservationSystem.addHotel("ridgewood", 220, 150,110, 150, 5);
		LocalDate startDate = LocalDate.of(2020, Month.SEPTEMBER, 11);    
		LocalDate endDate = LocalDate.of(2020, Month.SEPTEMBER, 12);    
		double totalRate = hotelReservationSystem.getCheapestHotelBasedOnWeekdayAndWeekEnd(startDate, endDate);
		assertEquals(160, totalRate);
	}
	
	@Test
	public void givenHotelList_shouldReturnCheapestHotelBasedOnRatings(){
		MainSystem hotelReservationSystem = new MainSystem();
		hotelReservationSystem.addHotel("bridgewood", 150, 50, 110, 150, 3);
		hotelReservationSystem.addHotel("lakeview", 110, 90,110, 150, 4);
		hotelReservationSystem.addHotel("ridgewood", 220, 150,110, 150, 5);
		LocalDate startDate = LocalDate.of(2020, Month.SEPTEMBER, 11);    
		LocalDate endDate = LocalDate.of(2020, Month.SEPTEMBER, 12);    
		Hotel hotel = hotelReservationSystem.getCheapestHotelBasedOnRatings(startDate, endDate);
		assertEquals("bridgewood", hotel.getHotelName());
		assertEquals(200, hotel.getRegularRateForDates(startDate, endDate));
	}
	
	@Test
	public void givenHotelList_shouldReturnHotelBasedOnRatings(){
		MainSystem hotelReservationSystem = new MainSystem();
		hotelReservationSystem.addHotel("bridgewood", 150, 50, 110, 150, 3);
		hotelReservationSystem.addHotel("lakeview", 110, 90,110, 150, 4);
		hotelReservationSystem.addHotel("ridgewood", 220, 150,110, 150, 5);
		LocalDate startDate = LocalDate.of(2020, Month.SEPTEMBER, 11);    
		LocalDate endDate = LocalDate.of(2020, Month.SEPTEMBER, 12);    
		Hotel hotel = hotelReservationSystem.getBestHotelBasedOnRatings(startDate, endDate);
		assertEquals("ridgewood", hotel.getHotelName());
		assertEquals(370, hotel.getRegularRateForDates(startDate, endDate));
	}
	
}
