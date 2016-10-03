/*
*@file_Name: WorldServiceImpl.java
*@Author: Shwetali
*@Date: 01-10-2016
*@purpose: class for implementions of service methods
*/
package com.bridgelabz.domain.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.dao.CountryDao;
import com.bridgelabz.domain.Country;

@Service
public class WorldServiceImpl implements WorldService {

	@Autowired
	private CountryDao countryDao;

	//getting list of countries
	public Collection<Country> getAllCountries() {
		return countryDao.getAll();
	}

	//get country by id
	public Country getCountryById(int countryId) {
		return countryDao.getById(countryId);
	}

	//get country by name
	public Country getCountryByName(String countryName) {
		return countryDao.getByName(countryName);
	}

	//save country inside database
	public void saveCountry(Country country) {
		countryDao.save(country);
	}

	//delete country from database
	public void deleteCountry(Country country) {
		countryDao.delete(country);
	}

}