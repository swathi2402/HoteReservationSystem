package com.bridgelabz.hotelreservation;

public class Hotel {
	private String hotelName;
	private double rateForWeekday;
	private double rateForWeekend;

	public Hotel(String hotelName, double rateForWeekday, double rateForWeekend) {
		super();
		this.hotelName = hotelName;
		this.rateForWeekday = rateForWeekday;
		this.rateForWeekend = rateForWeekend;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public double getRateForWeekday() {
		return rateForWeekday;
	}

	public void setRateForWeekday(double rateForWeekday) {
		this.rateForWeekday = rateForWeekday;
	}

	public double getRateForWeekend() {
		return rateForWeekend;
	}

	public void setRateForWeekend(double rateForWeekend) {
		this.rateForWeekend = rateForWeekend;
	}

}
