package com.bridgelabz.hotelreservation;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.hotelreservation.HotelReservation.CustomerType;

public class HotelReservationTest {

	@Test
	public void WhenGivenBridgewood_AddHotel_AndReturnTrue() {
		HotelReservation hoteReservation = new HotelReservation();
		boolean isAdded = hoteReservation.addHotel("Lakewood", 3, 110.0, 90.0, 80.0, 80.0);
		Assert.assertTrue(isAdded);
	}

	@Test
	public void WhenGivenName_AddHotel_AndReturnTrue() {
		HotelReservation hoteReservation = new HotelReservation();
		boolean isAdded = hoteReservation.addHotel("Bridgewood", 4, 150.0, 50.0, 110.0, 50.0);
		Assert.assertTrue(isAdded);
	}

	@Test
	public void WhenGivenRidgewood_AddHotel_AndReturnTrue() {
		HotelReservation hoteReservation = new HotelReservation();
		boolean isAdded = hoteReservation.addHotel("Ridgewood", 5, 220.0, 150.0, 100.0, 40.0);
		Assert.assertTrue(isAdded);
	}

	@Test
	public void WhenGivenHotelList_ShouldGive_CheapestHotelRate() {
		HotelReservation hoteReservation = new HotelReservation();
		hoteReservation.addHotel("Lakewood", 3, 110.0, 90.0, 80.0, 80.0);
		hoteReservation.addHotel("Bridgewood", 4, 150.0, 50.0, 110.0, 50.0);
		hoteReservation.addHotel("Ridgewood", 5, 220.0, 150.0, 100.0, 40.0);
		String startDate = "11Sep2020";
		String endDate = "12Sep2020";
		Hotel hotel = hoteReservation.findCheapBestHotel(startDate, endDate);
		Assert.assertEquals("Bridgewood", hotel.getHotelName());
	}

	@Test
	public void WhenGivenInvalidDate_ShouldGiveException() {
		HotelReservation hoteReservation = new HotelReservation();
		hoteReservation.addHotel("Lakewood", 3, 110.0, 90.0, 80.0, 80.0);
		hoteReservation.addHotel("Bridgewood", 4, 150.0, 50.0, 110.0, 50.0);
		hoteReservation.addHotel("Ridgewood", 5, 220.0, 150.0, 100.0, 40.0);
		String startDate = "11Sp2020";
		String endDate = "12Sep2020";
		try {
			Hotel hotel = hoteReservation.findCheapBestHotel(startDate, endDate);
			Assert.assertEquals("Bridgewood", hotel.getHotelName());
		} catch (HotelException e) {
			assertEquals(e.type, HotelException.ExceptionType.INVALID_DATE);
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void WhenGivenHotelList_ShouldGive_HightestRatedHotelRate() {
		HotelReservation hoteReservation = new HotelReservation();
		LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 10);
		LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
		Hotel hotel = hoteReservation.findBestRatedHotel(startDate, endDate);
		Assert.assertEquals("Ridgewood", hotel.getHotelName());
	}

	@Test
	public void WhenGivenHotelListAndInvalidDate_ShouldGiveException() {
		HotelReservation hoteReservation = new HotelReservation();
		String startDate = "11Sep2020";
		String endDate = "12Sp2020";
		try {
			Hotel hotel = hoteReservation.findCheapBestHotelForReward(startDate, endDate, CustomerType.REWARD_CUSTOMER);
			Assert.assertEquals("Ridgewood", hotel.getHotelName());
		} catch (HotelException e) {
			assertEquals(e.type, HotelException.ExceptionType.INVALID_DATE);
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void WhenNullDateGiven_ShouldGiveException() {
		HotelReservation hoteReservation = new HotelReservation();
		String startDate = "11Sep2020";
		String endDate = null;
		try {
			Hotel hotel = hoteReservation.findCheapBestHotelForReward(startDate, endDate, CustomerType.REWARD_CUSTOMER);
			Assert.assertEquals("Ridgewood", hotel.getHotelName());
		} catch (HotelException e) {
			assertEquals(e.type, HotelException.ExceptionType.ENTERED_NULL);
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void WhenGivenHotelList_ShouldGive_HightestRatedHotelRate_ForRewardCustomer() {
		HotelReservation hoteReservation = new HotelReservation();
		String startDate = "11Sep2020";
		String endDate = "12Sep2020";
		Hotel hotel = hoteReservation.findCheapBestHotelForReward(startDate, endDate, CustomerType.REWARD_CUSTOMER);
		Assert.assertEquals("Ridgewood", hotel.getHotelName());
	}

	@Test
	public void WhenGivenHotelList_ShouldGive_Null_ForRegularCustomer() {
		HotelReservation hoteReservation = new HotelReservation();
		String startDate = "11Sep2020";
		String endDate = "12Sep2020";
		Hotel hotel = hoteReservation.findCheapBestHotelForReward(startDate, endDate, CustomerType.REGULAR_CUSTOMER);
		Assert.assertNull(hotel);
	}

}
