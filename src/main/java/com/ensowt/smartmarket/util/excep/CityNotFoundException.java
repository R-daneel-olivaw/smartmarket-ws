package com.ensowt.smartmarket.util.excep;

public class CityNotFoundException extends Exception {

	public CityNotFoundException() {
		super();
	}

	public CityNotFoundException(String message) {
		super(message);
	}

	public CityNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
