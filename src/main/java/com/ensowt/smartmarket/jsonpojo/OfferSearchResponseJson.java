package com.ensowt.smartmarket.jsonpojo;

import java.util.List;

public class OfferSearchResponseJson {

	private ErrorJson error;
	private List<OfferJson> offers;

	public ErrorJson getError() {
		return error;
	}

	public void setError(ErrorJson error) {
		this.error = error;
	}

	public List<OfferJson> getOffers() {
		return offers;
	}

	public void setOffers(List<OfferJson> offers) {
		this.offers = offers;
	}

}
