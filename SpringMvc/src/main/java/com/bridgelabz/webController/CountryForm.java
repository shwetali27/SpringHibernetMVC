/*
*@file_Name: CountryForm.java
*@Author: Shwetali
*@Date: 28-09-2016
*@purpose: Controller class for performing the operations.
*/

package com.bridgelabz.webController;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bridgelabz.domain.Country;
import com.bridgelabz.domain.service.WorldService;
import com.bridgelabz.domain.validation.CountryValidator;

@Controller
@RequestMapping("/countryForm.html")
@SessionAttributes("country")
public class CountryForm {

	@Autowired
	private CountryValidator countryValidator;

	@Autowired
	private WorldService worldService;

	//for binding the for related to which data is required in which format
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		dataBinder.setDisallowedFields(new String[] { "id" });
		dataBinder.setRequiredFields(new String[] { "name", "area", "population", "currency" });
		dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(false));

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		dateFormat.setLenient(false);
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	//get method for setting up the form creating the country
	@RequestMapping(method = RequestMethod.GET)
	public Country setUpForm(@RequestParam(value = "id", required = false) Integer countryId) {
		System.out.println("creating new");
		if (countryId == null) {
			return new Country();
		} else {
			return worldService.getCountryById(countryId);
		}
	}

	/*//creating new country
	@RequestMapping(params = "create", method = RequestMethod.POST)
	public String create(Country country, BindingResult result, SessionStatus status) {
		System.out.println("Inside Create");
		return update(country, result, status);
	}*/

	//updating the country
	@RequestMapping(params = "update", method = RequestMethod.POST)
	public String update(Country country, BindingResult result, SessionStatus status) {
		System.out.println("Inside Update");
		countryValidator.validate(country, result);
		if (result.hasErrors()) {
			return "countryForm";
		} else {
			worldService.saveCountry(country);
			status.setComplete();//closing the session
			return "redirect:countryList.html";
		}
	}

	//deleting the country
	@RequestMapping(params = "delete", method = RequestMethod.POST)
	public String delete(Country country, BindingResult result, SessionStatus status) {
		System.out.println("Inside Delete");
		worldService.deleteCountry(country);
		status.setComplete();
		return "redirect:countryList.html";
	}

}