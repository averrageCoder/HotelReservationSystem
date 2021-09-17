package com.bridgelabz.hotelreservationsystem;

import java.time.LocalDate;
import java.util.ArrayList;

public interface HotelReservationService {
	
	public double getRegularRateForDates(Hotel hotel, LocalDate startDate, LocalDate endDate);
	public double getRewardRateForDates(Hotel hotel, LocalDate startDate, LocalDate endDate);
	public double getCheapestHotelBasedOnWeekdayAndWeekEnd(LocalDate startDate, LocalDate endDate);
	public void addHotel(Hotel hotel);
	public ArrayList<Hotel> getHotelList();
	public Hotel getBestHotelBasedOnRatings(LocalDate startDate, LocalDate endDate);
	public Hotel getCheapestHotelBasedOnRatingsForRewardCustomer(String startDateStr, String endDateStr);
	public Hotel getCheapestHotelBasedOnRatingsForRegularCustomer(String startDateStr, String endDateStr);
	
}
