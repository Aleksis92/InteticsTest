package com.latyshonak.web.api;

import com.latyshonak.service.ImagesService;
import com.latyshonak.service.UsersService;
import com.latyshonak.service.beans.ImageBean;
import com.latyshonak.service.beans.UsersBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping (value="/api/Images", produces="application/json")
public class ImagesAPI {

    @Autowired
    private UsersService usersService;

    @Autowired
    private ImagesService imagesService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ImageBean> checkImageForm (Authentication authentication, @RequestParam("image") MultipartFile file) {


        ImageBean imageBean = new ImageBean();
        imageBean.setCreatedBy(authentication.getName());
        try {
            imageBean.setImage(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }



        imageBean.setDescription("descr");
        imageBean.setName("name");
        imageBean.setTags("tags super-tags new-new-new");



        imagesService.saveImage(imageBean);

        return new ResponseEntity<ImageBean>(imagesService.getLastImage(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ImageBean>> Get() {
        return new ResponseEntity<List<ImageBean>>(imagesService.getAllImages(), HttpStatus.OK);
    }


}
