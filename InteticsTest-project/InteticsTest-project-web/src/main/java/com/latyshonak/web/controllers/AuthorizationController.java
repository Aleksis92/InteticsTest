package com.latyshonak.web.controllers;

import com.latyshonak.service.UsersService;
import com.latyshonak.service.beans.UsersBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
public class AuthorizationController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/Autorization", method = RequestMethod.POST)
    public String AutorizationPost(HttpSession session, @ModelAttribute("UserFromJspAutorization") UsersBean userFromJSP) {
        return "redirect:Autorization";
    }

    @RequestMapping(value = "/Autorization", method = RequestMethod.GET)
    public ModelAndView AutorizationGet(HttpSession session) {
            return new ModelAndView("redirect:Index");
            }

}
