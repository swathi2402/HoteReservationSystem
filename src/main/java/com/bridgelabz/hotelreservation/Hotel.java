package com.bridgelabz.hotelreservation;

public class Hotel {
	private String hotelName;
	private double rateForRegular;

	public Hotel(String hotelName, double rateForRegular2) {
		super();
		this.hotelName = hotelName;
		this.rateForRegular = rateForRegular2;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public double getRateForRegular() {
		return rateForRegular;
	}

	public void setRateForRegular(long rateForRegular) {
		this.rateForRegular = rateForRegular;
	}

}
