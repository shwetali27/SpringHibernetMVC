/*
*@file_Name: HelloWorldController.java
*@Author: Shwetali
*@Date: 28-09-2016
*@purpose: Controller class for performing the operations.
*/

package com.bridgelabz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.dao.LoginDaoImp;
import com.bridgelabz.dto.Login;

@Controller
public class HelloWorldController {
	@Autowired
	LoginDaoImp loginDaoImp;

	@RequestMapping(value = "helloworld")
	public ModelAndView helloWorld() {
		System.out.println("inside controller");
		String message = "Hello World, Spring 3.0!";
		return new ModelAndView("helloworld", "message", message);
	}

	@RequestMapping(value = "loginpage", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	// checking username and password
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String redirect(@Valid @ModelAttribute("validate") Login login, BindingResult result) {

		// validation
		if (result.hasErrors()) {
			System.out.println("errorfound");
			return "login";
		} else {
			System.out.println("User name" + login.getUsername());
			if (loginDaoImp.isValid(login.getUsername(), login.getPassword()))
				return "success";
			else
				return "error";
		}
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String showList(Model model) {
		model.addAttribute("list", loginDaoImp.showList());
		model.addAttribute("login", new Login());
		return "list";

	}

	@RequestMapping(value = "registerUser", method = RequestMethod.GET)
	public String register() {
		return "registerUser";
	}

	// registration of new user
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String registerUser(@Valid @ModelAttribute("validate") Login login, BindingResult result,
			HttpServletRequest request) {

		System.out.println("inside method registerUser");
		if (result.hasErrors()) {
			System.out.println("errorfound");
			return "register";
		} else {
			System.out.println("inside method registerUser else\n");
			String str = loginDaoImp.addUser(request.getParameter("username"), request.getParameter("password"));
			return str;
		}
	}
}
