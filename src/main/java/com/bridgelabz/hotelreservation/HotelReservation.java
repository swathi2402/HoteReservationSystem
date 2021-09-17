package com.bridgelabz.hotelreservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelReservation {
	static List<Hotel> hotelList = new ArrayList<Hotel>();

	public boolean addHotel(String hotelName, int rating, double rateForWeekday, double rateForWeekend) {
		Hotel hotel = new Hotel(hotelName, rating, rateForWeekday, rateForWeekend);
		boolean isAdded = hotelList.add(hotel);
		return isAdded;

	}

	public Hotel findCheapBestHotel(LocalDate startDate, LocalDate endDate) {

		int weekdayCount = 0;
		int weekendCount = 0;
		for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1)) {
			if (date.getDayOfWeek().getValue() <= 5)
				weekdayCount++;
			else
				weekendCount++;
		}
		final int weekdays = weekdayCount;
		final int weekends = weekendCount;

		Hotel hotel = hotelList.stream().sorted((h1, h2) -> {
			return h2.getRating() - h1.getRating();
		}).min((h1, h2) -> {
			return ((int) (h1.getRateForWeekday() * weekdays + h1.getRateForWeekend() * weekends)
					- (int) (h2.getRateForWeekday() * weekdays + h2.getRateForWeekend() * weekends));
		}).orElse(null);

		return hotel;
	}

	public Hotel findBestRatedHotel(LocalDate startDate, LocalDate endDate) {
		Hotel bestHotel = hotelList.stream().sorted((h1, h2) -> {
			return h2.getRating() - h1.getRating();
		}).findFirst().orElse(null);
		return bestHotel;
	}

	public static void main(String[] args) {

		System.out.println("Welcom to Hotel Reservation System");
	}

}
