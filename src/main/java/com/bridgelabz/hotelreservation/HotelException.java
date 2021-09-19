package com.bridgelabz.hotelreservation;

public class HotelException extends RuntimeException {
	
	enum ExceptionType {
		ENTERED_NULL, ENTERED_EMPTY, INVALID_DATE
	}

	ExceptionType type;

	public HotelException(ExceptionType type, String message) {
		super(message);
		this.type = type;
	}
}
