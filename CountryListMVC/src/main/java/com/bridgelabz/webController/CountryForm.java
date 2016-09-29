/*
*@file_Name: CountryForm.java
*@Author: Shwetali
*@Date: 29-09-2016
*@purpose: Controller class for adding new Data by Using form filling technique.
*/

package com.bridgelabz.webController;

import java.text.SimpleDateFormat;

import java.util.Date;

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
import com.bridgelabz.domain.service.MockWorldService;
import com.bridgelabz.domain.service.WorldService;
import com.bridgelabz.domain.validation.CountryValidator;

@Controller
@RequestMapping("/countryForm.html")
@SessionAttributes("country")
public class CountryForm {

	private WorldService worldService = new MockWorldService();

	private CountryValidator countryValidator = new CountryValidator();

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		dataBinder.setDisallowedFields(new String[] { "id" });
		dataBinder.setRequiredFields(new String[] { "name", "area", "population", "currency" });
		dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(false));

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		dateFormat.setLenient(false);
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	//get method for creating the new Entry
	@RequestMapping(method = RequestMethod.GET)
	public Country setUpForm(@RequestParam(value = "id", required = false) Integer countryId) {
		System.out.println("inside contry form get");
		if (countryId == null) {
			return new Country();
		} else {
			return worldService.getCountryById(countryId);
		}
	}

	//post method for creating the new entry and updating the data inside hash map
	@RequestMapping(params = "create", method = RequestMethod.POST)
	public String create(Country country, BindingResult result, SessionStatus status) {
		
		return update(country, result, status);
	}

	//updating the Exixting file
	@RequestMapping(params = "update", method = RequestMethod.POST)
	public String update(Country country, BindingResult result, SessionStatus status) {
		countryValidator.validate(country, result);
		if (result.hasErrors()) {
			return "countryForm";
		} else {
			worldService.saveCountry(country);
			status.setComplete();
			return "redirect:countryList.html";
		}
	}

	//deleting the existing file
	@RequestMapping(params = "delete", method = RequestMethod.POST)
	public String delete(Country country, BindingResult result, SessionStatus status) {
		worldService.deleteCountry(country);
		status.setComplete();
		return "redirect:countryList.html";
	}

}