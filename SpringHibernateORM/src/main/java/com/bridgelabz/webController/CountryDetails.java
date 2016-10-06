package com.bridgelabz.webController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.bridgelabz.domain.Country;
import com.bridgelabz.domain.service.WorldService;

@Controller
public class CountryDetails {
	String id;
	@Autowired
	private WorldService worldService;

	// details of each countries by id
	@RequestMapping(value="/countryDetails.html",method = RequestMethod.GET)
	public Country getCountry(@RequestParam(value = "id", required = true) int countryId,HttpServletRequest request) {
		id = request.getParameter("id");
		System.out.println("inside controller getCountry");
		return worldService.getCountryById(countryId);
	}

	@RequestMapping(value="/countryDetails.html",method = RequestMethod.POST)
	public String delete(Country country,SessionStatus status) {
		
		System.out.println("id is "+id);
		int countryId = Integer.parseInt(id);
		Country country1 = worldService.getCountryById(countryId);
		System.out.println("Inside CountryDetails delete Country:" + country1.getName());
		worldService.deleteCountry(country1);
		status.setComplete();
		return "redirect:countryList.html";
	}
	
}
