package com.ensowt.smartmarket.jsonpojo;

public class SellerJson {

	private String sellerName;
	private String sellerCity;
	private String sellerMarket;

	public SellerJson(String sellerName2, String cityName, String marketName) {
		sellerName = sellerName2;
		sellerCity = cityName;
		sellerMarket = marketName;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerCity() {
		return sellerCity;
	}

	public void setSellerCity(String sellerCity) {
		this.sellerCity = sellerCity;
	}

	public String getSellerMarket() {
		return sellerMarket;
	}

	public void setSellerMarket(String sellerMarket) {
		this.sellerMarket = sellerMarket;
	}

}
