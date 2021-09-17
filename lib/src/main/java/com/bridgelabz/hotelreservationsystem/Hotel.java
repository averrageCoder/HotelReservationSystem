package com.bridgelabz.hotelreservationsystem;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;



public class Hotel {
	
	enum CUSTOMER_TYPE {
		REGULAR, REWARD
	}
	
	enum TYPE_OF_DATE {
		WEEKDAY, WEEKEND
	}

	private String hotelName;
	Map<CUSTOMER_TYPE, Map<TYPE_OF_DATE, Integer>> rates = new HashMap<CUSTOMER_TYPE, Map<TYPE_OF_DATE, Integer>>();
	private int ratings;
	
	public String getHotelName() {
		return hotelName;
	}
	
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	public Map<CUSTOMER_TYPE, Map<TYPE_OF_DATE, Integer>> getRates() {
		return rates;
	}
	
	public void setRates(CUSTOMER_TYPE customerType, TYPE_OF_DATE typeOfDate, Integer rate) {
		if(this.rates.containsKey(customerType)) {
			this.rates.get(customerType).put(typeOfDate, rate);
		}
		else {
			Map<TYPE_OF_DATE, Integer> rateForTypeOfDate = new HashMap<TYPE_OF_DATE, Integer>(); 
			rateForTypeOfDate.put(typeOfDate, rate);
			this.rates.put(customerType, rateForTypeOfDate);
		}
	}
	
	public int getRatings() {
		return ratings;
	}
	
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	
	public Integer getRatesForRegularCustomerForWeekday() {
		if (this.rates.containsKey(CUSTOMER_TYPE.REGULAR)) {
			if(this.rates.get(CUSTOMER_TYPE.REGULAR).containsKey(TYPE_OF_DATE.WEEKDAY))
				return this.rates.get(CUSTOMER_TYPE.REGULAR).get(TYPE_OF_DATE.WEEKDAY);
		}
		return null;
	}
	
	public Integer getRatesForRegularCustomerForWeekend() {
		if (this.rates.containsKey(CUSTOMER_TYPE.REGULAR)) {
			if(this.rates.get(CUSTOMER_TYPE.REGULAR).containsKey(TYPE_OF_DATE.WEEKEND))
				return this.rates.get(CUSTOMER_TYPE.REGULAR).get(TYPE_OF_DATE.WEEKEND);
		}
		return null;
	}
	
	public Integer getRatesForRewardCustomerForWeekday() {
		if (this.rates.containsKey(CUSTOMER_TYPE.REWARD)) {
			if(this.rates.get(CUSTOMER_TYPE.REWARD).containsKey(TYPE_OF_DATE.WEEKDAY))
				return this.rates.get(CUSTOMER_TYPE.REWARD).get(TYPE_OF_DATE.WEEKDAY);
		}
		return null;
	}
	
	public Integer getRatesForRewardCustomerForWeekend() {
		if (this.rates.containsKey(CUSTOMER_TYPE.REWARD)) {
			if(this.rates.get(CUSTOMER_TYPE.REWARD).containsKey(TYPE_OF_DATE.WEEKEND))
				return this.rates.get(CUSTOMER_TYPE.REWARD).get(TYPE_OF_DATE.WEEKEND);
		}
		return null;
	}
}
