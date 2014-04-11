package com.ensowt.smartmarket.util.excep;

public class MarketNotFoundException extends Exception {

	public MarketNotFoundException() {
		super();
	}

	public MarketNotFoundException(String message) {
		super(message);
	}

	public MarketNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
