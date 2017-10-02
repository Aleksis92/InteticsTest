package com.latyshonak.web.controllers;


import com.latyshonak.service.UsersService;
import com.latyshonak.service.beans.UsersBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController  {

    @Autowired
    private UsersService usersService;

    @ModelAttribute("AllUserData")
    private UsersBean setUsername(Authentication authentication) {
        return usersService.getUserByEmail(authentication.getName());
    }

    @RequestMapping(value = "/index.html")
    public ModelAndView indexReturn () {

        return new ModelAndView("index");
    }
}
