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
		Hotel hotel = new Hotel();
		hotel.setHotelName("Lakewood");
		hotel.setRating(3);
		hotel.setRateForWeekday(110.0);
		hotel.setRateForWeekend(90.0);
		hotel.setRewardRateForWeekday(80.0);
		hotel.setRewardRateForWeekend(80.0);
		boolean isAdded = hoteReservation.addHotel(hotel);
		Assert.assertTrue(isAdded);
	}

	@Test
	public void WhenGivenName_AddHotel_AndReturnTrue() {
		HotelReservation hoteReservation = new HotelReservation();
		Hotel hotel = new Hotel();
		hotel.setHotelName("Bridgewood");
		hotel.setRating(4);
		hotel.setRateForWeekday(150.0);
		hotel.setRateForWeekend(50.0);
		hotel.setRewardRateForWeekday(110.0);
		hotel.setRewardRateForWeekend(50.0);
		boolean isAdded = hoteReservation.addHotel(hotel);
		Assert.assertTrue(isAdded);
	}

	@Test
	public void WhenGivenRidgewood_AddHotel_AndReturnTrue() {
		HotelReservation hoteReservation = new HotelReservation();
		Hotel hotel = new Hotel();
		hotel.setHotelName("Ridgewood");
		hotel.setRating(5);
		hotel.setRateForWeekday(220.0);
		hotel.setRateForWeekend(150.0);
		hotel.setRewardRateForWeekday(100.0);
		hotel.setRewardRateForWeekend(40.0);
		boolean isAdded = hoteReservation.addHotel(hotel);
		Assert.assertTrue(isAdded);
	}

	@Test
	public void WhenGivenHotelList_ShouldGive_CheapestHotelRate() {
		HotelReservation hoteReservation = new HotelReservation();

		Hotel hotel1 = new Hotel();
		hotel1.setHotelName("Lakewood");
		hotel1.setRating(3);
		hotel1.setRateForWeekday(110.0);
		hotel1.setRateForWeekend(90.0);
		hotel1.setRewardRateForWeekday(80.0);
		hotel1.setRewardRateForWeekend(80.0);
		hoteReservation.addHotel(hotel1);

		Hotel hotel2 = new Hotel();
		hotel2.setHotelName("Bridgewood");
		hotel2.setRating(4);
		hotel2.setRateForWeekday(150.0);
		hotel2.setRateForWeekend(50.0);
		hotel2.setRewardRateForWeekday(110.0);
		hotel2.setRewardRateForWeekend(50.0);
		hoteReservation.addHotel(hotel2);

		Hotel hotel3 = new Hotel();
		hotel3.setHotelName("Ridgewood");
		hotel3.setRating(5);
		hotel3.setRateForWeekday(220.0);
		hotel3.setRateForWeekend(150.0);
		hotel3.setRewardRateForWeekday(100.0);
		hotel3.setRewardRateForWeekend(40.0);
		hoteReservation.addHotel(hotel3);

		String startDate = "11Sep2020";
		String endDate = "12Sep2020";
		Hotel hotel = hoteReservation.findCheapBestHotel(startDate, endDate);
		Assert.assertEquals("Bridgewood", hotel.getHotelName());
	}

	@Test
	public void WhenGivenInvalidDate_ShouldGiveException() {
		HotelReservation hoteReservation = new HotelReservation();

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
