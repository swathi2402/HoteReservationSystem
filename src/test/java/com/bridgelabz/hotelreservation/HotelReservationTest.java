package com.bridgelabz.hotelreservation;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {

	@Test
	public void WhenGivenBridgewood_AddHotel_AndReturnTrue() {
		HotelReservation hoteReservation = new HotelReservation();
		boolean isAdded = hoteReservation.addHotel("Lakewood", 110.0, 90.0);
		Assert.assertTrue(isAdded);
	}

	@Test
	public void WhenGivenName_AddHotel_AndReturnTrue() {
		HotelReservation hoteReservation = new HotelReservation();
		boolean isAdded = hoteReservation.addHotel("Bridgewood", 150.0, 50.0);
		Assert.assertTrue(isAdded);
	}

	@Test
	public void WhenGivenRidgewood_AddHotel_AndReturnTrue() {
		HotelReservation hoteReservation = new HotelReservation();
		boolean isAdded = hoteReservation.addHotel("Ridgewood", 20.0, 150.0);
		Assert.assertTrue(isAdded);
	}

	@Test
	public void WhenGivenHotelList_ShouldGive_CheapestHotelRate() {
		HotelReservation hoteReservation = new HotelReservation();
		LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 13);
		LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 17);
		Hotel hotel = hoteReservation.findCheapHotel(startDate, endDate);
		Assert.assertEquals("Ridgewood", hotel.getHotelName());
	}

}
