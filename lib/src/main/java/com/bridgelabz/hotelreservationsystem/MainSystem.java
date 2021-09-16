package com.bridgelabz.hotelreservationsystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class MainSystem {
	
	private ArrayList<Hotel> hotelList = new ArrayList<>();

	public static void main(String[] args) {
		
		System.out.println("Welcome to hotel reservation system!");
		
		
	}
	
	public Hotel getCheapestHotel(LocalDate startDate, LocalDate endDate) {
		
		long noOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
		//System.out.println("No. of days between: "+noOfDaysBetween);
		Optional<Hotel> hotel = hotelList.stream().min(Comparator.comparing(Hotel::getRateForRegularCustomer));
		
		return hotel.get();
		
	}
	
	public void addHotel(String hotelName, double rateForRegularCustomer) {
		Hotel hotel = new Hotel();
		hotel.setHotelName(hotelName);
		hotel.setRateForRegularCustomer(rateForRegularCustomer);
		this.hotelList.add(hotel);	
	}
	
	public ArrayList<Hotel> getHotelList() {
		return this.hotelList;
	}

}
