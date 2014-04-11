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
import com.ensowt.smartmarket.gen.db.Market;
import com.ensowt.smartmarket.gen.db.Offer;

@Repository
public class OfferDao {

	private final Class<Offer> offerClass = Offer.class;
	@Autowired
	SessionFactory sessionFactory;

	public List<Offer> queryForOffers(City cityObject, Market marketObject) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(offerClass);

		criteria.createAlias("seller", "s");
		criteria.add(Restrictions.eq("s.market", marketObject));

		@SuppressWarnings("unchecked")
		List<Offer> list = (List<Offer>) criteria.list();

		for (Offer o : list) {
			Hibernate.initialize(o);
			Hibernate.initialize(o.getSeller().getSellerDetails());
		}

		return list;
	}

}
