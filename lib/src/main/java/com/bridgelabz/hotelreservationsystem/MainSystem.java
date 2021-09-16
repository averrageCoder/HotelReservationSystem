package com.bridgelabz.hotelreservationsystem;

import java.util.ArrayList;

public class MainSystem {
	
	private ArrayList<Hotel> hotelList = new ArrayList<>();

	public static void main(String[] args) {
		
		System.out.println("Welcome to hotel reservation system!");
		
		
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
