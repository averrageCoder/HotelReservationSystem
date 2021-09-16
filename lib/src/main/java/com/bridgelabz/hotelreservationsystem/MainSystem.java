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
	
	public double getCheapestHotel(LocalDate startDate, LocalDate endDate) {
		
		long noOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
		double totalRate = 0;
		
		Optional<Hotel> cheapestWeekdayhotel = hotelList.stream().min(Comparator.comparing(Hotel::getRateForWeekDay));
		Optional<Hotel> cheapestWeekendhotel = hotelList.stream().min(Comparator.comparing(Hotel::getRateForWeekEnd));
		
		for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1)) {
		    if(date.getDayOfWeek().getValue() <= 5) {
		    	System.out.println("On "+date+" "+date.getDayOfWeek()+" stay at "+cheapestWeekdayhotel.get().getHotelName());
		    	totalRate+=cheapestWeekdayhotel.get().getRateForWeekDay();
		    }
		    else {
		    	System.out.println("On "+date+" "+date.getDayOfWeek()+" stay at "+cheapestWeekendhotel.get().getHotelName());
		    	totalRate+=cheapestWeekendhotel.get().getRateForWeekEnd();
		    }
		}
		
		return totalRate;
		
	}
	
	public void addHotel(String hotelName, double rateForWeekDay, double rateForWeekEnd) {
		Hotel hotel = new Hotel();
		hotel.setHotelName(hotelName);
		hotel.setRateForWeekDay(rateForWeekDay);
		hotel.setRateForWeekEnd(rateForWeekEnd);
		this.hotelList.add(hotel);	
	}
	
	public ArrayList<Hotel> getHotelList() {
		return this.hotelList;
	}

}
