package com.bridgelabz.hotelreservation;

import java.time.LocalDate;
//import java.time.temporal.ChronoUnit;
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

//		long daysStaying = ChronoUnit.DAYS.between(startDate, endDate);
		Optional<Hotel> cheapestRate = hotelList.stream().min(Comparator.comparingDouble(Hotel::getRateForWeekday));
		return cheapestRate.get();

	}

	public static void main(String[] args) {

		System.out.println("Welcom to Hotel Reservation System");
	}

}
