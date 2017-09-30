package com.latyshonak.web.controllers;

import javax.servlet.http.HttpSession;


import com.latyshonak.service.UsersService;
import com.latyshonak.service.beans.UsersBean;
import com.latyshonak.service.utils.PreValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RegistrationController {

	@Autowired
	private UsersService usersService;

	@ModelAttribute("UserFromJspRegistration")
	private UsersBean getRegistrationUser() {
		return new UsersBean();
	}

	@RequestMapping(value = "/registrationPage.html")
	public String returnRegistrationPage(Model model) {
		return "registration";
	}

	@RequestMapping(value = "/registration.html", method = RequestMethod.POST)
	public String registrationPost(HttpSession session, @ModelAttribute("UserFromJspRegistration") UsersBean userFromJSP) {
		System.out.println(usersService.getUserByEmail(userFromJSP.getEmail()));
		if (usersService.getUserByEmail(userFromJSP.getEmail()).getEmail() == null) {
			if (PreValidation.checkEmail(userFromJSP.getEmail()) && PreValidation.checkPassword(userFromJSP.getPassword()) &&
					PreValidation.checkRepeatPassword(userFromJSP.getPassword(), userFromJSP.getRetypePassword())) {

				usersService.insertUser(userFromJSP.getUsername(), userFromJSP.getPassword(),
						userFromJSP.getEmail());
				return "redirect:registration.html";
			} else {
				return "redirect:/registration.html?denided_validation";
			}
		} else {
			return "redirect:/registration.html?denided_user";
		}
	}

		@RequestMapping(value = "/registration.html", method = RequestMethod.GET)
		public String registrationGet () { return "redirect:index.html"; }

}