package com.ensowt.smartmarket.mvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ensowt.smartmarket.gen.db.City;

@Repository
public class CityTableDao {

	@Autowired
	private SessionFactory sessionFactory;

	private final Class<City> cityClass = City.class;

	public City queryForCityName(String city) {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(cityClass);
		criteria.add(Restrictions.eq("cityName", city));
		criteria.setMaxResults(1);

		@SuppressWarnings("unchecked")
		List<City> list = (List<City>) criteria.list();

		if (list.size() == 0) {
			return null;
		}

		Hibernate.initialize(list.get(0));
		return list.get(0);
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
