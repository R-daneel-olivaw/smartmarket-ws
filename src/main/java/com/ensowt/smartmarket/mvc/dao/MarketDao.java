package com.ensowt.smartmarket.mvc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ensowt.smartmarket.gen.db.City;
import com.ensowt.smartmarket.gen.db.Market;

@Repository
public class MarketDao {

	@Autowired
	SessionFactory sessionFactory;

	public Market queryForMarketName(String market, City cityObject) {
		// TODO Auto-generated method stub
		return null;
	}
}
