/*
*@file_Name: CountryController.java
*@Author: Shwetali
*@Date: 29-09-2016
*@purpose: Controller class for performing the operations and handling link.
*/

package com.bridgelabz.webController;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.domain.Country;
import com.bridgelabz.domain.service.MockWorldService;
import com.bridgelabz.domain.service.WorldService;

@Controller
public class CountryController {

	private WorldService worldService = new MockWorldService();

	//programs info
	@RequestMapping(value = "/info.html")
	public ModelAndView helloWorld() {
		System.out.println("inside controller");
		String message = "Hello, This Program is to Display Country List and Details Using Spring";
		return new ModelAndView("helloworld", "message", message);
	}
	
	//show list of all countries
	@RequestMapping("/countryList.html")
	@ModelAttribute("countries")
	public Collection<Country> getCountries() {
		return worldService.getAllCountries();
	}

	//Calling country details by taking id as parameter using get method
	@RequestMapping("/countryDetails.html")
	public Country getCountry(@RequestParam(value = "id", required = true) int countryId) {
		return worldService.getCountryById(countryId);
	}
}