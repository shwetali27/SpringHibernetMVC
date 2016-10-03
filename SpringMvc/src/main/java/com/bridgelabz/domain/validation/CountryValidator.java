/*
*@file_Name: CountryValidator.java
*@Author: Shwetali
*@Date: 28-09-2016
*@purpose: performing validation operations.
*/

package com.bridgelabz.domain.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.bridgelabz.domain.Country;
import com.bridgelabz.domain.service.WorldService;

@Component
public class CountryValidator {

	@Autowired
	private WorldService worldService;

	public void validate(Country country, Errors errors) {

		//validation for area
		if (country.getArea() != null && country.getArea() <= 0) {
			errors.rejectValue("area", "validation.negative","must be positive");
		}

		//validation for population
		if (country.getPopulation() != null && country.getPopulation() <= 0) {
			errors.rejectValue("population", "validation.negative", "must be positive");
		}

		//validation for existing country
		if (!errors.hasFieldErrors("name")) {
			Country existingCountry = worldService.getCountryByName(country.getName());
			if (existingCountry != null && (country.isNew() || !country.getId().equals(existingCountry.getId()))) {
				errors.rejectValue("name", "validation.exists", "exists");
			}
		}
	}

}