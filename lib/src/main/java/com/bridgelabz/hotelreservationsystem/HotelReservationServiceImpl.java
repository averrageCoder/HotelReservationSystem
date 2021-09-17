package com.bridgelabz.hotelreservationsystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;


public class HotelReservationServiceImpl implements HotelReservationService  {
	
	private ArrayList<Hotel> hotelList = new ArrayList<>();
	
	@Override
	public double getRegularRateForDates(Hotel hotel, LocalDate startDate, LocalDate endDate) {
		double totalRate = 0;
		for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1)) {
		    if(date.getDayOfWeek().getValue() <= 5) {
		    	totalRate+=hotel.getRatesForRegularCustomerForWeekday();
		    }
		    else {
		    	totalRate+=hotel.getRatesForRegularCustomerForWeekend();
		    }
		}
		return totalRate;
	}

	@Override
	public double getRewardRateForDates(Hotel hotel, LocalDate startDate, LocalDate endDate) {
		double totalRate = 0;
		for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1)) {
		    if(date.getDayOfWeek().getValue() <= 5) {
		    	totalRate+=hotel.getRatesForRewardCustomerForWeekday();
		    }
		    else {
		    	totalRate+=hotel.getRatesForRewardCustomerForWeekend();
		    }
		}
		return totalRate;
	}

	@Override
	public double getCheapestHotelBasedOnWeekdayAndWeekEnd(LocalDate startDate, LocalDate endDate) {
		double totalRate = 0;
		
		Optional<Hotel> cheapestWeekdayhotel = hotelList.stream().min(Comparator.comparing(Hotel::getRatesForRegularCustomerForWeekday));
		Optional<Hotel> cheapestWeekendhotel = hotelList.stream().min(Comparator.comparing(Hotel::getRatesForRegularCustomerForWeekend));
		
		for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1)) {
		    if(date.getDayOfWeek().getValue() <= 5) {
		    	System.out.println("On "+date+" "+date.getDayOfWeek()+" stay at "+cheapestWeekdayhotel.get().getHotelName());
		    	totalRate+=cheapestWeekdayhotel.get().getRatesForRegularCustomerForWeekday();
		    }
		    else {
		    	System.out.println("On "+date+" "+date.getDayOfWeek()+" stay at "+cheapestWeekendhotel.get().getHotelName());
		    	totalRate+=cheapestWeekendhotel.get().getRatesForRegularCustomerForWeekend();
		    }
		}
		return totalRate;
	}

	@Override
	public void addHotel(Hotel hotel) {	
		this.hotelList.add(hotel);
	}

	@Override
	public ArrayList<Hotel> getHotelList() {
		return this.hotelList;
	}

	@Override
	public Hotel getBestHotelBasedOnRatings(LocalDate startDate, LocalDate endDate) {
		Optional<Hotel> hotel =  hotelList.stream()
				.max(Comparator.comparing(Hotel::getRatings));
		return hotel.get();
	}

	@Override
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

		Comparator<Hotel> cheapHotelForDates = (o1, o2) -> (int)getRewardRateForDates(o1,startDate, endDate) - (int)getRewardRateForDates(o2, startDate, endDate);
		Optional<Hotel> cheapestHotel = hotelList.stream()
				.min(cheapHotelForDates);
		
		double cheapestRateForDates = getRewardRateForDates(cheapestHotel.get(), startDate, endDate);
		
		Optional<Hotel> hotel =  cheapestHotel.stream()
				.filter(hotelObj -> getRewardRateForDates(hotelObj, startDate, endDate)==cheapestRateForDates)
				.max(Comparator.comparing(Hotel::getRatings));
		return hotel.get();
	}

	@Override
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
		
		Comparator<Hotel> cheapHotelForDates = (o1, o2) -> (int)getRegularRateForDates(o1,startDate, endDate) - (int)getRegularRateForDates(o2, startDate, endDate);
		Optional<Hotel> cheapestHotel = hotelList.stream()
				.min(cheapHotelForDates);
		
		double cheapestRateForDates = getRegularRateForDates(cheapestHotel.get(), startDate, endDate);
		
		Optional<Hotel> hotel =  cheapestHotel.stream()
				.filter(hotelObj -> getRegularRateForDates(hotelObj, startDate, endDate)==cheapestRateForDates)
				.max(Comparator.comparing(Hotel::getRatings));
		return hotel.get();
	}

}
