package com.bridgelabz.hotelreservation;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class HotelReservation {

	public enum CustomerType {

		REGULAR_CUSTOMER, REWARD_CUSTOMER
	}

	static List<Hotel> hotelList = new ArrayList<Hotel>();

	public boolean addHotel(String hotelName, int rating, double rateForWeekday, double rateForWeekend,
			double rewardRateForWeekday, double rewardRateForWeekend) {
		Hotel hotel = new Hotel(hotelName, rating, rateForWeekday, rateForWeekend, rewardRateForWeekday,
				rewardRateForWeekend);
		boolean isAdded = hotelList.add(hotel);
		return isAdded;

	}

	public Hotel findCheapBestHotel(String stringStartDate, String stringEndDate) {
		LocalDate startDate;
		LocalDate endDate;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMuuuu");
		try {
			startDate = LocalDate.parse(stringStartDate, formatter);
			endDate = LocalDate.parse(stringEndDate, formatter);
		} catch (DateTimeParseException e) {
			throw new HotelException(HotelException.ExceptionType.INVALID_DATE, "Enter a valid date");
		}

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

	public Hotel findCheapBestHotelForReward(String stringStartDate, String stringEndDate, CustomerType type)
			throws DateTimeException {
		LocalDate startDate;
		LocalDate endDate;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMuuuu");
		try {
			startDate = LocalDate.parse(stringStartDate, formatter);
			endDate = LocalDate.parse(stringEndDate, formatter);
		} catch (DateTimeParseException e) {
			throw new HotelException(HotelException.ExceptionType.INVALID_DATE, "Enter a valid date");
		}
		if (type == CustomerType.REWARD_CUSTOMER) {
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
				return ((int) (h1.getRewardRateForWeekday() * weekdays + h1.getRewardRateForWeekend() * weekends)
						- (int) (h2.getRewardRateForWeekday() * weekdays + h2.getRewardRateForWeekend() * weekends));
			}).orElse(null);

			return hotel;
		} else {
			return null;
		}

	}
}
