/*
*@file_Name: MockWorldService.java
*@Author: Shwetali
*@Date: 29-09-2016
*@purpose: validator class for data input.
*/
package com.bridgelabz.domain.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.bridgelabz.domain.Country;

public class MockWorldService implements WorldService {

	private static Map<Integer, Country> countries = new HashMap<Integer, Country>();
	private static int nextCountryId = 200;

	//adding static data inside hashMap having key as id and value as object
	static {
		countries.put(30, new Country(30, "Germany", 137847, 82046000L, parseDate("30-nov-2008"), "Euro"));
		countries.put(48, new Country(48, "Ghana", 92098, 23837000L, null, "Cedi"));
		countries.put(53,
				new Country(53, "Australia", 2966200, 21884000L, parseDate("04-sep-2009"), "Australian Dollar"));
		countries.put(73, new Country(73, "Greece", 50949, 11257285L, parseDate("1-jan-2009"), "Euro"));
		countries.put(122, new Country(122, "Georgia", 26900, 4382100L, parseDate("1-jan-2009"), "Lari"));
		countries.put(123,
				new Country(123, "New Zealand", 104454, 4320300L, parseDate("4-sep-2009"), "New Zealand Dollar"));
		countries.put(147, new Country(147, "Gambia", 4361, 1705000L, null, "Dalasi"));
		countries.put(149, new Country(149, "Gabon", 103347, 1475000L, null, "CFA franc"));
	}

	//parsing the date into specific format
	private static Date parseDate(String textDate) {
		try {
			return new SimpleDateFormat("dd-MMM-yyyy").parse(textDate);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	//method to show list of countries
	public Collection<Country> getAllCountries() {
		System.out.println("Inside Return all countries");
		return countries.values();
	}

	//returns the data for selected country.
	public Country getCountryById(int countryId) {
		// Returns a new object and not just a reference
		// to an object in the collection.
		Country country = countries.get(countryId);
		return new Country(country.getId(), country.getName(), country.getArea(), country.getPopulation(),
				country.getPopulationLastUpdated(), country.getCurrency());
	}

	//method to check for existing country
	public Country getCountryByName(String countryName) {
		for (Country country : countries.values()) {
			if (country.getName().toLowerCase().equals(countryName.toLowerCase())) {
				return country;
			}
		}
		return null;
	}

	//method to save Country
	public void saveCountry(Country country) {
		if (country.isNew()) {
			nextCountryId++;
			country.setId(nextCountryId);
			countries.put(nextCountryId, country);
		} else {
			countries.put(country.getId(), country);
		}
	}

	//deleting the country
	public void deleteCountry(Country country) {
		countries.remove(country.getId());
	}

}
