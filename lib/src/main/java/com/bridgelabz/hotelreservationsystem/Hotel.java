package com.bridgelabz.hotelreservationsystem;

public class Hotel {

	private String hotelName;
	private double rateForWeekDay;
	private double rateForWeekEnd;
	
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
	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", rateForWeekDay=" + rateForWeekDay + ", rateForWeekEnd="
				+ rateForWeekEnd + "]";
	}
}
