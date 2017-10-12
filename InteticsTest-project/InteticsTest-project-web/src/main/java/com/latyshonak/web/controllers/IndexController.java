package com.latyshonak.web.controllers;


import com.latyshonak.service.ImagesService;
import com.latyshonak.service.UsersService;
import com.latyshonak.service.beans.ImageBean;
import com.latyshonak.service.beans.UsersBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class IndexController  {

    @Autowired
    private UsersService usersService;

    @Autowired
    private ImagesService imagesService;

    @ModelAttribute("AllUserData")
    private UsersBean setUserBeanDefault(Authentication authentication) {
        return usersService.getUserByEmail(authentication.getName());
    }

    @ModelAttribute("ImageFromJSP")
    private ImageBean setImageBeanDefault() {
        return new ImageBean();
    }

    @RequestMapping(value = "/index.html")
    public ModelAndView indexReturn () {

        return new ModelAndView("index");
    }

    @RequestMapping(value = "/uploadImage.html")
    public ModelAndView uploadImage (@RequestParam("file") MultipartFile file) {
        ImageBean imageBean = new ImageBean();
        try {
            imageBean.setImage(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        };
        imagesService.saveImage(imageBean);

        return new ModelAndView("index");

    }


    @RequestMapping(value = "/uploadImageForm.html")
    public ModelAndView uploadImageForm (@ModelAttribute("ImageFromJSP") ImageBean imageBean, @RequestParam("file") MultipartFile file) {
        System.out.println(imageBean);
        try {
            imageBean.setImage(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        };
        imagesService.saveImage(imageBean);

        return new ModelAndView("index");

    }

}
