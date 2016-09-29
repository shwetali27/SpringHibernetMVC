/*
*@file_Name: CountryValidator.java
*@Author: Shwetali
*@Date: 29-09-2016
*@purpose: validator class for data input.
*/

package com.bridgelabz.domain.validation;

import org.springframework.validation.Errors;

import com.bridgelabz.domain.Country;
import com.bridgelabz.domain.service.MockWorldService;
import com.bridgelabz.domain.service.WorldService;

public class CountryValidator {

	private WorldService worldService = new MockWorldService();

	public void validate(Country country, Errors errors) {

		if (country.getArea() != null && country.getArea() <= 0) {
			errors.rejectValue("area", "validation.negative", "must be > 0");
		}

		if (country.getPopulation() != null && country.getPopulation() <= 0) {
			errors.rejectValue("population", "validation.negative", "must be > 0");
		}

		if (!errors.hasFieldErrors("name")) {
			Country existingCountry = worldService.getCountryByName(country.getName());
			if (existingCountry != null && (country.isNew() || !country.getId().equals(existingCountry.getId()))) {
				errors.rejectValue("name", "validation.exists", "exists");
			}
		}
	}

}