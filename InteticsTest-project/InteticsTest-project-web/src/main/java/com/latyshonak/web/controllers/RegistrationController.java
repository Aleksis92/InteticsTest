package com.latyshonak.web.controllers;

import javax.servlet.http.HttpSession;


import com.latyshonak.service.UsersService;
import com.latyshonak.service.beans.UsersBean;
import com.latyshonak.service.utils.PreValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RegistrationController {

	@Autowired
	private UsersService usersService;

	@RequestMapping(value = "/Registration", method = RequestMethod.POST)
	public String RegistrationPost(HttpSession session, @ModelAttribute("UserFromJspRegistration") UsersBean userFromJSP) {

		return "redirect:Registration";
	}


	@RequestMapping(value = "/Registration", method = RequestMethod.GET)
	public String RegistrationGet() {
		return "index";
	}

}