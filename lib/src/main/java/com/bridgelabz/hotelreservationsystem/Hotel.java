package com.bridgelabz.hotelreservationsystem;

import java.time.LocalDate;
public class Hotel {

	private String hotelName;
	private double rateForWeekDay;
	private double rateForWeekEnd;
	private int ratings;
	
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public double getRateForWeekDay() {
		return rateForWeekDay;
	}
	public void setRateForWeekDay(double rateForWeekDay) {
		this.rateForWeekDay = rateForWeekDay;
	}
	public double getRateForWeekEnd() {
		return rateForWeekEnd;
	}
	public void setRateForWeekEnd(double rateForWeekEnd) {
		this.rateForWeekEnd = rateForWeekEnd;
	}
	public double getRateForDates(LocalDate startDate, LocalDate endDate) {
		double totalRate = 0;
		
		for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1)) {
		    if(date.getDayOfWeek().getValue() <= 5) {
		    	totalRate+=this.rateForWeekDay;
		    }
		    else {
		    	totalRate+=this.rateForWeekEnd;
		    }
		}
		return totalRate;
	}
	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", rateForWeekDay=" + rateForWeekDay + ", rateForWeekEnd="
				+ rateForWeekEnd + ", ratings=" + ratings + "]";
	}
}
