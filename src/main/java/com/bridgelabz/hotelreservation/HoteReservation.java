package com.bridgelabz.hotelreservation;

import java.util.ArrayList;
import java.util.List;

public class HoteReservation {
	List<Hotel> hotelList = new ArrayList<Hotel>();

	public boolean addHotel(String hotelName, double rateForRegular) {
		Hotel hotel = new Hotel(hotelName, rateForRegular);
		hotelList.add(hotel);
		return true;
	}

	public static void main(String[] args) {
		
		System.out.println("Welcom to Hotel Reservation System");
	}

}
