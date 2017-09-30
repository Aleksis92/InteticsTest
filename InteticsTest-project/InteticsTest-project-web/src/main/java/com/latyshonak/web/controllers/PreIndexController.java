package com.latyshonak.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class PreIndexController {

    @RequestMapping(value = "/")
    public ModelAndView indexReturn (HttpSession session) {
        return new ModelAndView("redirect:index.html");
    }
}
