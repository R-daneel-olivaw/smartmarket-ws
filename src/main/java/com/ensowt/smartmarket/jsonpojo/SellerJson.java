package com.ensowt.smartmarket.jsonpojo;

public class SellerJson {

	private String sellerName;
	private String sellerCity;
	private String sellerMarket;
	private String sellerAddress;

	public SellerJson(String sellerName2, String cityName, String marketName, String address) {
		sellerName = sellerName2;
		sellerCity = cityName;
		sellerMarket = marketName;
		sellerAddress = address;
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

	public String getSellerAddress() {
		return sellerAddress;
	}

	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}
}
