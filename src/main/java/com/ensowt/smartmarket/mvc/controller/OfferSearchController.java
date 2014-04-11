package com.ensowt.smartmarket.mvc.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ensowt.smartmarket.gen.db.City;
import com.ensowt.smartmarket.gen.db.Market;
import com.ensowt.smartmarket.jsonpojo.OfferJson;
import com.ensowt.smartmarket.mvc.service.OfferSearchService;
import com.ensowt.smartmarket.util.excep.CityNotFoundException;
import com.ensowt.smartmarket.util.excep.MarketNotFoundException;

@Controller
@RequestMapping("offerSearch")
public class OfferSearchController {

	@Autowired
	private OfferSearchService offerSearchService;
	private static final Logger logger = Logger
			.getLogger(OfferSearchController.class);

	/**
	 * http://localhost:8080/SmartMarketWS/offerSearch/getOffersByCityMarket?
	 * city=noida&market=sector-18
	 * 
	 * @param city
	 * @param market
	 * @return
	 * @throws CityNotFoundException
	 * @throws MarketNotFoundException
	 */
	@RequestMapping(value = "/getOffersByCityMarket", method = RequestMethod.GET)
	@ResponseBody
	public List<OfferJson> getOffers(
			@RequestParam(value = "city", required = true) String city,
			@RequestParam(value = "market", required = true) String market)
			throws CityNotFoundException, MarketNotFoundException {

		City cityObject = offerSearchService.fetchCity(city);
		Market marketObject = offerSearchService
				.fetchMarket(market, cityObject);

		List<OfferJson> jsonList = offerSearchService.fetchOffers(cityObject,
				marketObject);

		return jsonList;
	}
}
