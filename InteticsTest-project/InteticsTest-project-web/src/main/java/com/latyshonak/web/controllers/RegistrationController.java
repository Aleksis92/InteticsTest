package com.latyshonak.web.controllers;

import com.latyshonak.service.CustomProvider;
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

	@Autowired
	private CustomProvider customProvider;

	@ModelAttribute("UserFromJspRegistration")
	private UsersBean getRegistrationUser() {
		return new UsersBean();
	}

	@RequestMapping(value = "/registrationPage.html")
	public String returnRegistrationPage() {
		return "registration";
	}

	@RequestMapping(value = "/registration.html", method = RequestMethod.POST)
	public String registrationPost(@ModelAttribute("UserFromJspRegistration") UsersBean userFromJSP) {
		if (usersService.getUserByEmail(userFromJSP.getEmail()).getEmail() != null) {
			return "redirect:/registrationPage.html?denided_user";
		}
		if (PreValidation.checkEmail(userFromJSP.getEmail()) &&
			PreValidation.checkPassword(userFromJSP.getPassword()) &&
			PreValidation.checkRepeatPassword(userFromJSP.getPassword(), userFromJSP.getRetypePassword()) &&
			PreValidation.checkUsername(userFromJSP.getUsername())) {

			usersService.insertUser(userFromJSP.getUsername(), userFromJSP.getPassword(),
					userFromJSP.getEmail());
			customProvider.authenticate(userFromJSP.getEmail());
			return "redirect:registration.html";

		} else {
			return "redirect:/registrationPage.html?denided_validation";

		}
	}

		@RequestMapping(value = "/registration.html", method = RequestMethod.GET)
		public String registrationGet () { return "redirect:index.html"; }

}