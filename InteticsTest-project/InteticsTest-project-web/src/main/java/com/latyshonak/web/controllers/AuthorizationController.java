package com.latyshonak.web.controllers;

import com.latyshonak.service.UsersService;
import com.latyshonak.service.beans.UsersBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class AuthorizationController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/authorization.html", method = RequestMethod.GET)
    public ModelAndView AuthorizationGet() {
            return new ModelAndView("authorization");
            }

    @RequestMapping(value = "/logout.html", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:/authorization.html?logout";
    }

    @RequestMapping(value = "/access_denided.html", method = RequestMethod.GET)
    public String accessDeniedPage() {
        return "redirect:/authorization.html?denided";
    }

}
