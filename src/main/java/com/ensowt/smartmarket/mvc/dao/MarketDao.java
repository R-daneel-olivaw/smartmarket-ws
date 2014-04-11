package com.ensowt.smartmarket.mvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ensowt.smartmarket.gen.db.City;
import com.ensowt.smartmarket.gen.db.Market;

@Repository
public class MarketDao {

	private final Class<Market> marketClass = Market.class;
	@Autowired
	SessionFactory sessionFactory;

	public Market queryForMarketName(String market, City cityObject) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(marketClass);

		criteria.add(Restrictions.and(Restrictions.eq("marketName", market),
				Restrictions.eq("city", cityObject)));
		criteria.setMaxResults(1);

		@SuppressWarnings("unchecked")
		List<Market> list = (List<Market>) criteria.list();

		if (list.size() == 0) {
			return null;
		}

		return list.get(0);
	}
}
