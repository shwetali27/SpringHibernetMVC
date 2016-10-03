/*
*@file_Name: CountryDao.java
*@Author: Shwetali
*@Date: 01-10-2016
*@purpose: Interface for performing operations related to database
*/
package com.bridgelabz.dao;

import java.util.Collection;

import com.bridgelabz.domain.Country;

public interface CountryDao {

	public Collection<Country> getAll();

	public Country getById(int countryId);

	public Country getByName(String countryName);

	public void save(Country country);

	public void delete(Country country);

}
