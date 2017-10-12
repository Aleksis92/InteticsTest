package com.latyshonak.service;

import com.latyshonak.service.beans.ImageBean;

import java.util.List;

public interface ImagesService {


    void saveImage(ImageBean imageBean);

    ImageBean getImagesById(String id);

    List<ImageBean> getAllImages();

    ImageBean getLastImage();
}
