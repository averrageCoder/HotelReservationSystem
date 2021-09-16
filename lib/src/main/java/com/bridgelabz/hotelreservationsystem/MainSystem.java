package com.bridgelabz.hotelreservationsystem;

import java.time.LocalDateTime;
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
	
	public Hotel getCheapestHotel(LocalDateTime startDate, LocalDateTime endDate) {
		
		long noOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
		
		ArrayList<Hotel> hotel = hotelList.stream().sorted(Comparator.comparing(Hotel::getRateForRegularCustomer))
		.collect(Collectors.toCollection(ArrayList::new));
		
		return hotel.get(0);
		
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
