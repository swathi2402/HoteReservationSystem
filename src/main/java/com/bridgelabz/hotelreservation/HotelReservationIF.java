package com.bridgelabz.hotelreservation;

import java.time.LocalDate;

import com.bridgelabz.hotelreservation.HotelReservationImpl.CustomerType;

public interface HotelReservationIF {
	
	public boolean addHotel(Hotel hotel);

	public Hotel findCheapBestHotel(String stringStartDate, String stringEndDate);

	public Hotel findBestRatedHotel(LocalDate startDate, LocalDate endDate);

	public Hotel findCheapBestHotelForReward(String stringStartDate, String stringEndDate, CustomerType type);

}
