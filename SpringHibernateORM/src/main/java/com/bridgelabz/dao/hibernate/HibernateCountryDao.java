/*
*@file_Name: HibernateCountryDao.java
*@Author: Shwetali
*@Date: 01-10-2016
*@purpose: operations related to database operations
*/

package com.bridgelabz.dao.hibernate;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bridgelabz.dao.CountryDao;
import com.bridgelabz.domain.Country;

@Repository
public class HibernateCountryDao implements CountryDao {

	@Autowired
	SessionFactory sessionFactory;

	// getting the coountry details from database by id
	public Country getById(int countryId) {
		System.out.println("Inside HibernateCountryDao getting Country by id transaction");

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// hibernate query for getting country for id
		Query query = session.createQuery("from Country where ctry_id=?");
		query.setInteger(0, countryId);
		Country country = (Country) query.uniqueResult();

		System.out.println("HibernateCountryDao- Country name is:" + country.getName());
		return country;

	}

	// getting the coountry details from database by name this method is called
	// during validation
	public Country getByName(String countryName) {
		System.out.println("Inside getting Country by name transaction");

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// hibernate queries
		Query query = session.createQuery("from Country where ctry_name=?");
		query.setString(0, countryName);
		Object queryResult = query.uniqueResult();

		// if name not found inside database then value of queryResult will be
		// null
		if (queryResult != null) {
			Country country = (Country) queryResult;
			System.out.println("Country name is:" + country.getName());
			return country; // if country is present then return country
							// else return null
		}
		return null;
	}

	// for getting list of all countries inside database
	public Collection<Country> getAll() {
		Query query = (Query) sessionFactory.openSession().createQuery("from Country");
		List<Country> list = query.list();
		return list;
	}

	//for saving new country or updating existing country
	public void save(Country country) {
		Session session = sessionFactory.openSession();
		
		//if country id is null create new entry in database else update 
		if (country.getId() == null) {
			System.out.println("Inside save HibernateCountryDao " + country.getName());
			Transaction tr = session.beginTransaction();
			session.save(country);
			tr.commit();
		}
		
		else {
			System.out.println("Inside save HibernateCountryDao " + country.getName());
			Transaction transaction = session.beginTransaction();
			session.update(country);
			transaction.commit();
		}
	}

	//deleting the country from database
	public void delete(Country country) {
		Session session = sessionFactory.openSession();
		
		System.out.println("Inside Delete HibernateCountryDao " + country.getName());
		Transaction transaction = session.beginTransaction();
		session.delete(country);
		transaction.commit();
	}

}