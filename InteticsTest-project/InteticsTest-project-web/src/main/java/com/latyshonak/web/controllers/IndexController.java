package com.latyshonak.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController  {


    @RequestMapping(value = "/index.html")
    public ModelAndView indexReturn (HttpSession session) {
        return new ModelAndView("index");
    }
}
