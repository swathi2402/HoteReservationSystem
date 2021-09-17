package com.bridgelabz.hotelreservation;

public class Hotel {
	private String hotelName;
	private int rating;
	private double rateForWeekday;
	private double rateForWeekend;
	private double rewardRateForWeekday;
	private double rewardRateForWeekend;

	public Hotel(String hotelName, int rating, double rateForWeekday, double rateForWeekend,
			double rewardRateForWeekday, double rewardRateForWeekend) {
		super();
		this.hotelName = hotelName;
		this.rating = rating;
		this.rateForWeekday = rateForWeekday;
		this.rateForWeekend = rateForWeekend;
		this.rewardRateForWeekday = rewardRateForWeekday;
		this.rewardRateForWeekend = rewardRateForWeekend;
	}

		public double getRewardRateForWeekday() {
		return rewardRateForWeekday;
	}

	public void setRewardRateForWeekday(double rewardRateForWeekday) {
		this.rewardRateForWeekday = rewardRateForWeekday;
	}

	public double getRewardRateForWeekend() {
		return rewardRateForWeekend;
	}

	public void setRewardRateForWeekend(double rewardRateForWeekend) {
		this.rewardRateForWeekend = rewardRateForWeekend;
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
