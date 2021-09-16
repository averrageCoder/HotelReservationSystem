package com.bridgelabz.hotelreservationsystem;

import java.util.ArrayList;

public class MainSystem {
	
	private static ArrayList<Hotel> hotelList = new ArrayList<>();

	public static void main(String[] args) {
		
		System.out.println("Welcome to hotel reservation system!");
		
		
	}
	
	public static void addHotel(String hotelName, double rateForRegularCustomer) {
		
		Hotel hotel = new Hotel();
		hotel.setHotelName(hotelName);
		hotel.setRateForRegularCustomer(rateForRegularCustomer);
		hotelList.add(hotel);
		
	}
	
	public static ArrayList<Hotel> getHotelList() {
		return hotelList;
	}

}
