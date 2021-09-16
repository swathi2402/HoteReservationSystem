package com.bridgelabz.hotelreservation;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {
	
	@Test
	public void WhenGivenName_AddHotel_AndReturnTrue() {
		HoteReservation hoteReservation = new HoteReservation();
		boolean isAdded = hoteReservation.addHotel("Lakewood", 110.0);
		Assert.assertTrue(isAdded);
	}
}
