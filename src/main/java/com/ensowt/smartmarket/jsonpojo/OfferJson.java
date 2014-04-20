package com.ensowt.smartmarket.jsonpojo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;

import com.ensowt.smartmarket.gen.db.Offer;
import com.ensowt.smartmarket.gen.db.SellerDetails;

public class OfferJson {

	private String offer;
	private String offerType;
	private SellerJson seller;

	public OfferJson(String offerName, String offerType2, SellerJson sellerJson) {
		offer = offerName;
		offerType = offerType2;
		seller = sellerJson;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

	public String getOfferType() {
		return offerType;
	}

	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}

	public SellerJson getSeller() {
		return seller;
	}

	public void setSeller(SellerJson seller) {
		this.seller = seller;
	}

	public static List<OfferJson> covertToJson(List<Offer> offerList) {

		List<OfferJson> list = new ArrayList<>();

		for (Offer o : offerList) {
			SellerDetails sellerDetails = o.getSeller().getSellerDetails();

			SellerJson sellerJson = new SellerJson(
					sellerDetails.getSellerName(), o.getSeller().getMarket()
							.getCity().getCityName(), o.getSeller().getMarket()
							.getMarketName(),sellerDetails.getSellerAddress());

			OfferJson ojson = new OfferJson(o.getOfferName(), o.getOfferType(),
					sellerJson);
			list.add(ojson);
		}

		return list;
	}

}
