/*
*@file_Name: CountryController.java
*@Author: Shwetali
*@Date: 01-10-2016
*@purpose: controller class for getting info, list of countries and details
*/

package com.bridgelabz.webController;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.domain.Country;
import com.bridgelabz.domain.service.WorldService;

@Controller
public class CountryController {

	@Autowired
	private WorldService worldService;

	// displaying the info about project
	@RequestMapping(value = "/info.html")
	public ModelAndView helloWorld() {
		System.out.println("inside controller Country");
		String message = "Hello, This Program is to Display Country List and Details Using Spring-Hibernate and database";
		return new ModelAndView("helloworld", "message", message);
	}

	//show list of countries
	@RequestMapping("/countryList.html")
	@ModelAttribute("countries")
	public Collection<Country> getCountries() {
		return worldService.getAllCountries();
	}
	
	@RequestMapping(value="/countryD/{id}", method = RequestMethod.GET)
	public String remove(@RequestParam("id") int id, Country country, BindingResult result, SessionStatus status) {
		System.out.println("Inside CountryForm delete Country:" + id);
		worldService.deleteCountry(country);
		status.setComplete();
		return "redirect:countryList.html";
	}
}