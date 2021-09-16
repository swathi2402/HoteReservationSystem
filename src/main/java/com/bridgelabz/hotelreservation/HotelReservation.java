package com.bridgelabz.hotelreservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class HotelReservation {
	static List<Hotel> hotelList = new ArrayList<Hotel>();

	public boolean addHotel(String hotelName, double rateForWeekday, double rateForWeekend) {
		Hotel hotel = new Hotel(hotelName, rateForWeekday, rateForWeekend);
		boolean isAdded = hotelList.add(hotel);
		return isAdded;

	}

	public Hotel findCheapHotel(LocalDate startDate, LocalDate endDate) {

		int weekdayCount = 0;
		int weekendCount = 0;
		Optional<Hotel> cheapestWeekdayHotel = hotelList.stream()
				.min(Comparator.comparingDouble(Hotel::getRateForWeekday));
		Optional<Hotel> cheapestWeekendHotel = hotelList.stream()
				.min(Comparator.comparingDouble(Hotel::getRateForWeekend));

		for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1)) {
			if (date.getDayOfWeek().getValue() <= 5)
				weekdayCount++;
			else
				weekendCount++;
		}
		
		double price1 = (weekdayCount * cheapestWeekdayHotel.get().getRateForWeekday())
				+ (weekendCount * cheapestWeekdayHotel.get().getRateForWeekend());
		double price2 = (weekdayCount * cheapestWeekendHotel.get().getRateForWeekday())
				+ (weekendCount * cheapestWeekendHotel.get().getRateForWeekend());
		
		if (price1 < price2)
			return cheapestWeekdayHotel.get();
		else
			return cheapestWeekendHotel.get();

	}

	public static void main(String[] args) {

		System.out.println("Welcom to Hotel Reservation System");
	}

}
