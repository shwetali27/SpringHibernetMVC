/*
*@file_Name: WorldService.java
*@Author: Shwetali
*@Date: 01-10-2016
*@purpose: interface for service methods
*/

package com.bridgelabz.domain.service;

import java.util.Collection;

import com.bridgelabz.domain.Country;

public interface WorldService {

	public Collection<Country> getAllCountries();

	public Country getCountryById(int countryId);

	public Country getCountryByName(String countryName);

	public void saveCountry(Country country);

	public void deleteCountry(Country country);

}