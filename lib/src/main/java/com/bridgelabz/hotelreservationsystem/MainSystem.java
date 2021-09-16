package com.bridgelabz.hotelreservationsystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
		
		Optional<Hotel> cheapestWeekdayhotel = hotelList.stream().min(Comparator.comparing(Hotel::getRateForWeekDayForRegularCustomer));
		Optional<Hotel> cheapestWeekendhotel = hotelList.stream().min(Comparator.comparing(Hotel::getRateForWeekEndForRegularCustomer));
		
		for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1)) {
		    if(date.getDayOfWeek().getValue() <= 5) {
		    	System.out.println("On "+date+" "+date.getDayOfWeek()+" stay at "+cheapestWeekdayhotel.get().getHotelName());
		    	totalRate+=cheapestWeekdayhotel.get().getRateForWeekDayForRegularCustomer();
		    }
		    else {
		    	System.out.println("On "+date+" "+date.getDayOfWeek()+" stay at "+cheapestWeekendhotel.get().getHotelName());
		    	totalRate+=cheapestWeekendhotel.get().getRateForWeekEndForRegularCustomer();
		    }
		}
		return totalRate;
	}
	
public double getCheapestHotel(LocalDate startDate, LocalDate endDate) {
		
		long noOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
		double totalRate = 0;
		
		Optional<Hotel> cheapestWeekdayhotel = hotelList.stream().min(Comparator.comparing(Hotel::getRateForWeekDayForRegularCustomer));
		Optional<Hotel> cheapestWeekendhotel = hotelList.stream().min(Comparator.comparing(Hotel::getRateForWeekEndForRegularCustomer));
		
		for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1)) {
		    if(date.getDayOfWeek().getValue() <= 5) {
		    	System.out.println("On "+date+" "+date.getDayOfWeek()+" stay at "+cheapestWeekdayhotel.get().getHotelName());
		    	totalRate+=cheapestWeekdayhotel.get().getRateForWeekDayForRegularCustomer();
		    }
		    else {
		    	System.out.println("On "+date+" "+date.getDayOfWeek()+" stay at "+cheapestWeekendhotel.get().getHotelName());
		    	totalRate+=cheapestWeekendhotel.get().getRateForWeekEndForRegularCustomer();
		    }
		}
		return totalRate;
	}
	
	public void addHotel(String hotelName, double rateForWeekDay, double rateForWeekEnd, double rewardRateForWeekDay, double rewardRateForWeekEnd, int ratings) {
		Hotel hotel = new Hotel();
		hotel.setHotelName(hotelName);
		hotel.setRateForWeekDayForRegularCustomer(rateForWeekDay);
		hotel.setRateForWeekEndForRegularCustomer(rateForWeekEnd);
		hotel.setRateForWeekDayForRewardCustomer(rewardRateForWeekDay);
		hotel.setRateForWeekEndForRewardCustomer(rewardRateForWeekEnd);
		hotel.setRatings(ratings);
		this.hotelList.add(hotel);	
	}
	
	public ArrayList<Hotel> getHotelList() {
		return this.hotelList;
	}

	public Hotel getCheapestHotelBasedOnRatings(LocalDate startDate, LocalDate endDate) {
		long noOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
		double totalRate = 0;
		
		Comparator<Hotel> cheapHotelForDates = (o1, o2) -> (int)o1.getRewardRateForDates(startDate, endDate) - (int)o2.getRewardRateForDates(startDate, endDate);
		
		Optional<Hotel> cheapestHotel = hotelList.stream()
				.min(cheapHotelForDates);
		
		double cheapestRateForDates = cheapestHotel.get().getRewardRateForDates(startDate, endDate);
		
		Optional<Hotel> hotel =  cheapestHotel.stream()
				.filter(o -> o.getRewardRateForDates(startDate, endDate)==cheapestRateForDates)
				.max(Comparator.comparing(Hotel::getRatings));
		return hotel.get();
	}

	public Hotel getBestHotelBasedOnRatings(LocalDate startDate, LocalDate endDate) {
		Optional<Hotel> hotel =  hotelList.stream()
				.max(Comparator.comparing(Hotel::getRatings));
		
		return hotel.get();
	}

	public Hotel getCheapestHotelBasedOnRatingsForRewardCustomer(String startDateStr, String endDateStr) {
		
		LocalDate startDate;
		LocalDate endDate;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMuuuu");
		try {
			startDate = LocalDate.parse(startDateStr,formatter);
			endDate = LocalDate.parse(endDateStr,formatter);
		}
		catch (DateTimeParseException e) {
			throw new HotelException(HotelException.ExceptionType.INVALID_DATE, "Please enter a valid date");
		}
		
		
		double totalRate = 0;
		Comparator<Hotel> cheapHotelForDates = (o1, o2) -> (int)o1.getRewardRateForDates(startDate, endDate) - (int)o2.getRewardRateForDates(startDate, endDate);
		Optional<Hotel> cheapestHotel = hotelList.stream()
				.min(cheapHotelForDates);
		
		double cheapestRateForDates = cheapestHotel.get().getRewardRateForDates(startDate, endDate);
		
		System.out.println("Cheapest Hotel list: "+cheapestHotel);
		
		Optional<Hotel> hotel =  cheapestHotel.stream()
				.filter(o -> o.getRewardRateForDates(startDate, endDate)==cheapestRateForDates)
				.max(Comparator.comparing(Hotel::getRatings));
		return hotel.get();
	}
	
public Hotel getCheapestHotelBasedOnRatingsForRegularCustomer(String startDateStr, String endDateStr) {
		
		LocalDate startDate;
		LocalDate endDate;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMuuuu");
		try {
			startDate = LocalDate.parse(startDateStr,formatter);
			endDate = LocalDate.parse(endDateStr,formatter);
		}
		catch (DateTimeParseException e) {
			throw new HotelException(HotelException.ExceptionType.INVALID_DATE, "Please enter a valid date");
		}
		
		double totalRate = 0;
		Comparator<Hotel> cheapHotelForDates = (o1, o2) -> (int)o1.getRegularRateForDates(startDate, endDate) - (int)o2.getRegularRateForDates(startDate, endDate);
		Optional<Hotel> cheapestHotel = hotelList.stream()
				.min(cheapHotelForDates);
		
		double cheapestRateForDates = cheapestHotel.get().getRegularRateForDates(startDate, endDate);
		
		System.out.println("Cheapest Hotel list: "+cheapestHotel);
		
		Optional<Hotel> hotel =  cheapestHotel.stream()
				.filter(o -> o.getRegularRateForDates(startDate, endDate)==cheapestRateForDates)
				.max(Comparator.comparing(Hotel::getRatings));
		return hotel.get();
	}

}
