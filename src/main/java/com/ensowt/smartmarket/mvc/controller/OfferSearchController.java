package com.ensowt.smartmarket.mvc.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ensowt.smartmarket.gen.db.City;
import com.ensowt.smartmarket.gen.db.Market;
import com.ensowt.smartmarket.jsonpojo.OfferJson;
import com.ensowt.smartmarket.mvc.service.OfferSearchService;
import com.ensowt.smartmarket.util.ds.OfferSearchCommand;
import com.ensowt.smartmarket.util.excep.CityNotFoundException;
import com.ensowt.smartmarket.util.excep.MarketNotFoundException;

@Controller
@RequestMapping("offerSearch")
@SessionAttributes("command")
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
	@RequestMapping(value = "/getOffersByCityMarket/json.smt", method = RequestMethod.GET)
	@ResponseBody
	public List<OfferJson> getOffers(
			@RequestParam(value = "city", required = true) String city,
			@RequestParam(value = "market", required = true) String market)
			throws CityNotFoundException, MarketNotFoundException {

		// http://localhost:8080/SmartMarketWS/offerSearch/getOffersByCityMarket/json.smt?market=sector-18&city=noida

		City cityObject = offerSearchService.fetchCity(city);
		Market marketObject = offerSearchService
				.fetchMarket(market, cityObject);

		List<OfferJson> jsonList = offerSearchService.fetchOffers(cityObject,
				marketObject);

		return jsonList;
	}

	@RequestMapping(value = "/getOffersByCityMarket", method = RequestMethod.GET)
	public String getOffers(
			@ModelAttribute("command") OfferSearchCommand searchCommand,
			Model model, final SessionStatus status)
			throws CityNotFoundException, MarketNotFoundException {

		String city = searchCommand.getCityName();
		String market = searchCommand.getMarketName();

		City cityObject = offerSearchService.fetchCity(city);
		Market marketObject = offerSearchService
				.fetchMarket(market, cityObject);

		List<OfferJson> jsonList = offerSearchService.fetchOffers(cityObject,
				marketObject);

		model.addAttribute("searchResults", jsonList);

		return "searchOffer";
	}

	@ModelAttribute("command")
	private OfferSearchCommand generateCandidate() {
		OfferSearchCommand searchCommand = new OfferSearchCommand();
		// candidate.initialize();
		return searchCommand;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showWelcomePage(Model model,
			@ModelAttribute("command") OfferSearchCommand candidate,
			final SessionStatus status) {

		if(candidate.getCityName()!=null || candidate.getMarketName()!=null)
		{
			status.setComplete();
			candidate = new OfferSearchCommand(); 
		}
		
		model.addAttribute("command", candidate);

		return "searchOffer";
	}
}
