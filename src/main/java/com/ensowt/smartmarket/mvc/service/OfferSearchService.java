package com.ensowt.smartmarket.mvc.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensowt.smartmarket.gen.db.City;
import com.ensowt.smartmarket.gen.db.Market;
import com.ensowt.smartmarket.gen.db.Offer;
import com.ensowt.smartmarket.jsonpojo.OfferJson;
import com.ensowt.smartmarket.mvc.dao.CityTableDao;
import com.ensowt.smartmarket.mvc.dao.MarketDao;
import com.ensowt.smartmarket.mvc.dao.OfferDao;
import com.ensowt.smartmarket.util.excep.CityNotFoundException;
import com.ensowt.smartmarket.util.excep.MarketNotFoundException;

@Service
public class OfferSearchService {

	@Autowired
	private CityTableDao cityDao;

	@Autowired
	private MarketDao marketDao;

	@Autowired
	private OfferDao offerDao;

	@Transactional
	public City fetchCity(String city) throws CityNotFoundException {

		if (city == null || city.trim().length() == 0) {
			throw new IllegalArgumentException("City can not be null or empty");
		}

		City cityObj = cityDao.queryForCityName(city);

		if (cityObj == null) {
			cityObj = cityDao.queryForCityAliasName(city);
		}
		if (cityObj == null) {
			cityObj = cityDao.queryForCityCode(city);
		}

		if (cityObj == null) {
			throw new CityNotFoundException("City with identifier " + city
					+ " not found.");
		}

		return cityObj;
	}

	@Transactional
	public Market fetchMarket(String market, City cityObject)
			throws MarketNotFoundException {

		if (market == null || market.trim().length() == 0) {
			throw new IllegalArgumentException(
					"Market can not be null or empty");
		}

		Market marketObj = marketDao.queryForMarketName(market, cityObject);

		if (marketObj == null) {
			throw new MarketNotFoundException("Market in City "
					+ cityObject.getCityName() + " with identifier " + market
					+ " not found.");
		}

		return marketObj;
	}

	@Transactional
	public List<OfferJson> fetchOffers(City cityObject, Market marketObject) {

		List<Offer> offerList = offerDao.queryForOffers(cityObject,
				marketObject);
		List<OfferJson> jsonList = OfferJson.covertToJson(offerList);

		return jsonList;
	}
}
