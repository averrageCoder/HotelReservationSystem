package com.bridgelabz.hotelreservationsystem;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class HotelTest {

	@Test
	public void givenHotelName_shouldReturnProperHotelName(){
		HotelReservationService hotelReservationSystem = new HotelReservationServiceImpl();
		Hotel hotel = new Hotel();
		hotel.setHotelName("bridge");
		hotel.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKDAY, 100);
		hotel.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKDAY, 110);
		hotel.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel.setRatings(3);
		hotelReservationSystem.addHotel(hotel);
		ArrayList<Hotel> hotelList = hotelReservationSystem.getHotelList();
		assertEquals("bridge", hotelList.get(0).getHotelName());
	}
	
	@Test
	public void givenHotelRate_shouldReturnProperHotelWeekDayRate(){
		HotelReservationService hotelReservationSystem = new HotelReservationServiceImpl();
		Hotel hotel = new Hotel();
		hotel.setHotelName("bridge");
		hotel.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKDAY, 100);
		hotel.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKDAY, 110);
		hotel.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel.setRatings(3);
		hotelReservationSystem.addHotel(hotel);
		ArrayList<Hotel> hotelList = hotelReservationSystem.getHotelList();
		assertEquals(100, hotelList.get(0).getRatesForRegularCustomerForWeekday());
	}
	
	@Test
	public void givenHotelRate_shouldReturnProperHotelWeekdEndRate(){
		HotelReservationService hotelReservationSystem = new HotelReservationServiceImpl();
		Hotel hotel = new Hotel();
		hotel.setHotelName("bridge");
		hotel.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKDAY, 100);
		hotel.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKDAY, 110);
		hotel.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel.setRatings(3);
		hotelReservationSystem.addHotel(hotel);
		ArrayList<Hotel> hotelList = hotelReservationSystem.getHotelList();
		assertEquals(150, hotelList.get(0).getRatesForRegularCustomerForWeekend());
	}
	
	@Test
	public void givenHotelRate_shouldReturnProperHotelWeekDayRateForRewardCustomer(){
		HotelReservationService hotelReservationSystem = new HotelReservationServiceImpl();
		Hotel hotel = new Hotel();
		hotel.setHotelName("bridge");
		hotel.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKDAY, 100);
		hotel.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKDAY, 110);
		hotel.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel.setRatings(3);
		hotelReservationSystem.addHotel(hotel);
		ArrayList<Hotel> hotelList = hotelReservationSystem.getHotelList();
		assertEquals(110, hotelList.get(0).getRatesForRewardCustomerForWeekday());
	}
	
	@Test
	public void givenHotelRate_shouldReturnProperHotelWeekdEndRateForRewardCustomer(){
		HotelReservationService hotelReservationSystem = new HotelReservationServiceImpl();
		Hotel hotel = new Hotel();
		hotel.setHotelName("bridge");
		hotel.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKDAY, 100);
		hotel.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKDAY, 110);
		hotel.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel.setRatings(3);
		hotelReservationSystem.addHotel(hotel);
		ArrayList<Hotel> hotelList = hotelReservationSystem.getHotelList();
		assertEquals(150, hotelList.get(0).getRatesForRewardCustomerForWeekend());
	}
	
	@Test
	public void givenHotel_shouldReturnProperHotelRating(){
		HotelReservationService hotelReservationSystem = new HotelReservationServiceImpl();
		Hotel hotel = new Hotel();
		hotel.setHotelName("bridge");
		hotel.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKDAY, 100);
		hotel.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKDAY, 110);
		hotel.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel.setRatings(3);
		hotelReservationSystem.addHotel(hotel);
		ArrayList<Hotel> hotelList = hotelReservationSystem.getHotelList();
		assertEquals(3, hotelList.get(0).getRatings());
	}
	
	@Test
	public void givenHotelList_shouldReturnProperSize() {
		HotelReservationService hotelReservationSystem = new HotelReservationServiceImpl();
		Hotel hotel = new Hotel();
		hotel.setHotelName("bridge");
		hotel.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKDAY, 100);
		hotel.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKDAY, 110);
		hotel.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel.setRatings(3);
		hotelReservationSystem.addHotel(hotel);
		ArrayList<Hotel> hotelList = hotelReservationSystem.getHotelList();
		assertEquals(1, hotelList.size());
	}
	
	
	
	@Test
	public void givenHotelList_shouldReturnCheapestHotelBasedOnWeekdayAndWeekend(){
		HotelReservationService hotelReservationSystem = new HotelReservationServiceImpl();
		Hotel hotel1 = new Hotel();
		hotel1.setHotelName("bridge");
		hotel1.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKDAY, 150);
		hotel1.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKEND, 50);
		hotel1.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKDAY, 110);
		hotel1.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel1.setRatings(3);
		Hotel hotel2 = new Hotel();
		hotel2.setHotelName("lakeview");
		hotel2.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKDAY, 110);
		hotel2.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKEND, 90);
		hotel2.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKDAY, 110);
		hotel2.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel2.setRatings(4);
		Hotel hotel3 = new Hotel();
		hotel3.setHotelName("ridgewood");
		hotel3.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKDAY, 220);
		hotel3.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel3.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKDAY, 100);
		hotel3.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKEND, 40);
		hotel3.setRatings(5);
		hotelReservationSystem.addHotel(hotel1);
		hotelReservationSystem.addHotel(hotel2);
		hotelReservationSystem.addHotel(hotel3);
		LocalDate startDate = LocalDate.of(2020, Month.SEPTEMBER, 11);    
		LocalDate endDate = LocalDate.of(2020, Month.SEPTEMBER, 12);    
		double totalRate = hotelReservationSystem.getCheapestHotelBasedOnWeekdayAndWeekEnd(startDate, endDate);
		assertEquals(160, totalRate);
	}
	
	@Test
	public void givenHotelList_shouldReturnCheapestHotelBasedOnRatings(){
		HotelReservationService hotelReservationSystem = new HotelReservationServiceImpl();
		Hotel hotel1 = new Hotel();
		hotel1.setHotelName("bridge");
		hotel1.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKDAY, 150);
		hotel1.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKEND, 50);
		hotel1.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKDAY, 110);
		hotel1.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel1.setRatings(3);
		Hotel hotel2 = new Hotel();
		hotel2.setHotelName("lakeview");
		hotel2.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKDAY, 110);
		hotel2.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKEND, 90);
		hotel2.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKDAY, 110);
		hotel2.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel2.setRatings(4);
		Hotel hotel3 = new Hotel();
		hotel3.setHotelName("ridgewood");
		hotel3.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKDAY, 220);
		hotel3.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel3.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKDAY, 100);
		hotel3.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKEND, 40);
		hotel3.setRatings(5);
		hotelReservationSystem.addHotel(hotel1);
		hotelReservationSystem.addHotel(hotel2);
		hotelReservationSystem.addHotel(hotel3);
		String startDate = "11Sep2020";  
		String endDate = "12Sep2020";
		Hotel hotel = hotelReservationSystem.getCheapestHotelBasedOnRatingsForRegularCustomer(startDate, endDate);
		assertEquals(hotel, hotel1);
		LocalDate startDate1 = LocalDate.of(2020, Month.SEPTEMBER, 11);    
		LocalDate endDate1 = LocalDate.of(2020, Month.SEPTEMBER, 12);   
		assertEquals(200, hotelReservationSystem.getRegularRateForDates(hotel, startDate1, endDate1));
	}
	
	@Test
	public void givenHotelList_shouldReturnHotelBasedOnRatings(){
		HotelReservationService hotelReservationSystem = new HotelReservationServiceImpl();
		Hotel hotel1 = new Hotel();
		hotel1.setHotelName("bridge");
		hotel1.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKDAY, 150);
		hotel1.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKEND, 50);
		hotel1.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKDAY, 110);
		hotel1.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel1.setRatings(3);
		Hotel hotel2 = new Hotel();
		hotel2.setHotelName("lakeview");
		hotel2.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKDAY, 110);
		hotel2.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKEND, 90);
		hotel2.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKDAY, 110);
		hotel2.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel2.setRatings(4);
		Hotel hotel3 = new Hotel();
		hotel3.setHotelName("ridgewood");
		hotel3.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKDAY, 220);
		hotel3.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel3.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKDAY, 100);
		hotel3.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKEND, 40);
		hotel3.setRatings(5);
		hotelReservationSystem.addHotel(hotel1);
		hotelReservationSystem.addHotel(hotel2);
		hotelReservationSystem.addHotel(hotel3);
		LocalDate startDate = LocalDate.of(2020, Month.SEPTEMBER, 11);    
		LocalDate endDate = LocalDate.of(2020, Month.SEPTEMBER, 12);    
		Hotel hotel = hotelReservationSystem.getBestHotelBasedOnRatings(startDate, endDate);
		assertEquals(hotel, hotel3);
	}
	
	@Test
	public void givenHotelList_shouldReturnCheapestHotelBasedOnRatingsForRewardCustomer(){
		HotelReservationService hotelReservationSystem = new HotelReservationServiceImpl();
		Hotel hotel1 = new Hotel();
		hotel1.setHotelName("bridge");
		hotel1.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKDAY, 150);
		hotel1.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKEND, 50);
		hotel1.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKDAY, 110);
		hotel1.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel1.setRatings(3);
		Hotel hotel2 = new Hotel();
		hotel2.setHotelName("lakeview");
		hotel2.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKDAY, 110);
		hotel2.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKEND, 90);
		hotel2.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKDAY, 110);
		hotel2.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel2.setRatings(4);
		Hotel hotel3 = new Hotel();
		hotel3.setHotelName("ridgewood");
		hotel3.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKDAY, 220);
		hotel3.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel3.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKDAY, 100);
		hotel3.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKEND, 40);
		hotel3.setRatings(5);
		hotelReservationSystem.addHotel(hotel1);
		hotelReservationSystem.addHotel(hotel2);
		hotelReservationSystem.addHotel(hotel3);
		String startDate = "11Sep2020";  
		String endDate = "12Sep2020";
		try {
			Hotel hotel = hotelReservationSystem.getCheapestHotelBasedOnRatingsForRewardCustomer(startDate, endDate);
			assertEquals(hotel, hotel3);
		}
		catch (HotelException e) {
			assertEquals(e.type, HotelException.ExceptionType.INVALID_DATE);
		}
	}
	
	@Test
	public void givenHotelList_shouldReturnCheapestHotelBasedOnRatingsForRegularCustomer(){
		HotelReservationService hotelReservationSystem = new HotelReservationServiceImpl();
		Hotel hotel1 = new Hotel();
		hotel1.setHotelName("bridge");
		hotel1.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKDAY, 150);
		hotel1.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKEND, 50);
		hotel1.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKDAY, 110);
		hotel1.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel1.setRatings(3);
		Hotel hotel2 = new Hotel();
		hotel2.setHotelName("lakeview");
		hotel2.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKDAY, 110);
		hotel2.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKEND, 90);
		hotel2.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKDAY, 110);
		hotel2.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel2.setRatings(4);
		Hotel hotel3 = new Hotel();
		hotel3.setHotelName("ridgewood");
		hotel3.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKDAY, 220);
		hotel3.setRates(Hotel.CUSTOMER_TYPE.REGULAR, Hotel.TYPE_OF_DATE.WEEKEND, 150);
		hotel3.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKDAY, 100);
		hotel3.setRates(Hotel.CUSTOMER_TYPE.REWARD, Hotel.TYPE_OF_DATE.WEEKEND, 40);
		hotel3.setRatings(5);
		hotelReservationSystem.addHotel(hotel1);
		hotelReservationSystem.addHotel(hotel2);
		hotelReservationSystem.addHotel(hotel3);
		String startDate = "11Sep2020";  
		String endDate = "12Sep2020";
		try {
			Hotel hotel = hotelReservationSystem.getCheapestHotelBasedOnRatingsForRegularCustomer(startDate, endDate);
			assertEquals(hotel, hotel1);
		}
		catch (HotelException e) {
			assertEquals(e.type, HotelException.ExceptionType.INVALID_DATE);
		}
	}
	
}
