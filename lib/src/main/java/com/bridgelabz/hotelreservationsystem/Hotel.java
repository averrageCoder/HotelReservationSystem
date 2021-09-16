package com.bridgelabz.hotelreservationsystem;

import java.time.LocalDate;
public class Hotel {

	private String hotelName;
	private double rateForWeekDayForRegularCustomer;
	private double rateForWeekEndForRegularCustomer;
	private double rateForWeekDayForRewardCustomer;
	private double rateForWeekEndForRewardCustomer;
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
	public double getRateForWeekDayForRegularCustomer() {
		return rateForWeekDayForRegularCustomer;
	}
	public void setRateForWeekDayForRegularCustomer(double rateForWeekDay) {
		this.rateForWeekDayForRegularCustomer = rateForWeekDay;
	}
	public double getRateForWeekEndForRegularCustomer() {
		return rateForWeekEndForRegularCustomer;
	}
	public void setRateForWeekEndForRegularCustomer(double rateForWeekEnd) {
		this.rateForWeekEndForRegularCustomer = rateForWeekEnd;
	}
	public double getRateForWeekDayForRewardCustomer() {
		return rateForWeekDayForRewardCustomer;
	}
	public void setRateForWeekDayForRewardCustomer(double rateForWeekDayForRewardCustomer) {
		this.rateForWeekDayForRewardCustomer = rateForWeekDayForRewardCustomer;
	}
	public double getRateForWeekEndForRewardCustomer() {
		return rateForWeekEndForRewardCustomer;
	}
	public void setRateForWeekEndForRewardCustomer(double rateForWeekEndForRewardCustomer) {
		this.rateForWeekEndForRewardCustomer = rateForWeekEndForRewardCustomer;
	}
	public double getRegularRateForDates(LocalDate startDate, LocalDate endDate) {
		double totalRate = 0;
		for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1)) {
		    if(date.getDayOfWeek().getValue() <= 5) {
		    	totalRate+=this.rateForWeekDayForRegularCustomer;
		    }
		    else {
		    	totalRate+=this.rateForWeekEndForRegularCustomer;
		    }
		}
		return totalRate;
	}
	public double getRewardRateForDates(LocalDate startDate, LocalDate endDate) {
		double totalRate = 0;
		for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1)) {
		    if(date.getDayOfWeek().getValue() <= 5) {
		    	totalRate+=this.rateForWeekDayForRewardCustomer;
		    }
		    else {
		    	totalRate+=this.rateForWeekEndForRewardCustomer;
		    }
		}
		return totalRate;
	}
}
