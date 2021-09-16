package com.bridgelabz.hotelreservationsystem;

public class Hotel {

	private String hotelName;
	private double rateForRegularCustomer;
	
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public double getRateForRegularCustomer() {
		return rateForRegularCustomer;
	}
	public void setRateForRegularCustomer(double rateForRegularCustomer) {
		this.rateForRegularCustomer = rateForRegularCustomer;
	}
	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", rateForRegularCustomer=" + rateForRegularCustomer + "]";
	}
	
}
