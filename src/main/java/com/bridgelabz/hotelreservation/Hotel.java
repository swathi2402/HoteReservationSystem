package com.bridgelabz.hotelreservation;

public class Hotel {
	private String hotelName;
	private int rating;
	private double rateForWeekday;
	private double rateForWeekend;

	public Hotel(String hotelName, int rating, double rateForWeekday, double rateForWeekend) {
		super();
		this.hotelName = hotelName;
		this.rating = rating;
		this.rateForWeekday = rateForWeekday;
		this.rateForWeekend = rateForWeekend;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
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
