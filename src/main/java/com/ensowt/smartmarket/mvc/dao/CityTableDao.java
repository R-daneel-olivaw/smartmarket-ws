package com.ensowt.smartmarket.mvc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ensowt.smartmarket.gen.db.City;

@Repository
public class CityTableDao {

	@Autowired
	SessionFactory sessionFactory;

	public City queryForCityName(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	public City queryForCityAliasName(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	public City queryForCityCode(String city) {
		// TODO Auto-generated method stub
		return null;
	}
}
