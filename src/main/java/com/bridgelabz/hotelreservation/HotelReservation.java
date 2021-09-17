package com.bridgelabz.hotelreservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelReservation {
	static List<Hotel> hotelList = new ArrayList<Hotel>();

	public boolean addHotel(String hotelName, double rateForRegular) {
		Hotel hotel = new Hotel(hotelName, rateForRegular);
		boolean isAdded = hotelList.add(hotel);
		return isAdded;

	}

	public Hotel findCheapHotel(LocalDate startDate, LocalDate endDate) {

		Hotel hotel = hotelList.stream().min((h1,h2) -> {
			return (int) (h1.getRateForRegular() - h2.getRateForRegular());
		}).orElse(null);

		return hotel;

	}

	public static void main(String[] args) {

		System.out.println("Welcom to Hotel Reservation System");
	}

}
