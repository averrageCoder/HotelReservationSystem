package com.bridgelabz.hotelreservationsystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class MainSystem {
	
	private ArrayList<Hotel> hotelList = new ArrayList<>();

	public static void main(String[] args) {
		
		System.out.println("Welcome to hotel reservation system!");
		
		
	}
	
	public double getCheapestHotelBasedOnWeekdayAndWeekEnd(LocalDate startDate, LocalDate endDate) {
		
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
	
	public void addHotel(String hotelName, double rateForWeekDay, double rateForWeekEnd, int ratings) {
		Hotel hotel = new Hotel();
		hotel.setHotelName(hotelName);
		hotel.setRateForWeekDay(rateForWeekDay);
		hotel.setRateForWeekEnd(rateForWeekEnd);
		hotel.setRatings(ratings);
		this.hotelList.add(hotel);	
	}
	
	public ArrayList<Hotel> getHotelList() {
		return this.hotelList;
	}

	public Hotel getCheapestHotelBasedOnRatings(LocalDate startDate, LocalDate endDate) {
		long noOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
		double totalRate = 0;
		
		Comparator<Hotel> cheapHotelForDates = (o1, o2) -> (int)o1.getRateForDates(startDate, endDate) - (int)o2.getRateForDates(startDate, endDate);
		
		Optional<Hotel> cheapestHotel = hotelList.stream()
				.min(cheapHotelForDates);
		
		double cheapestRateForDates = cheapestHotel.get().getRateForDates(startDate, endDate);
		
		System.out.println("Cheapest Hotel list: "+cheapestHotel);
		
		Optional<Hotel> hotel =  cheapestHotel.stream()
				.filter(o -> o.getRateForDates(startDate, endDate)==cheapestRateForDates)
				.max(Comparator.comparing(Hotel::getRatings));
		return hotel.get();
	}

	public Hotel getBestHotelBasedOnRatings(LocalDate startDate, LocalDate endDate) {
		Optional<Hotel> hotel =  hotelList.stream()
				.max(Comparator.comparing(Hotel::getRatings));
		
		return hotel.get();
	}

}
