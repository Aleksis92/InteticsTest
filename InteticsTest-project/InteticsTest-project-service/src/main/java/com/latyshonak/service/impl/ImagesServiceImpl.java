package com.latyshonak.service.impl;

import com.latyshonak.dao.Entity.Images;
import com.latyshonak.dao.ImagesDao;
import com.latyshonak.service.EntityBeanConverter;
import com.latyshonak.service.ImagesService;
import com.latyshonak.service.beans.ImageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ImagesServiceImpl implements ImagesService {

    @Autowired
    private ImagesDao imagesDao;

    @Autowired
    private EntityBeanConverter converter;

    @Override
    public void saveImage(ImageBean imageBean) {
        Images images = converter.convertToEntity(imageBean, Images.class);
        imagesDao.save(images);
    }

    @Override
    public ImageBean getImagesById(String id) {
        return null;
    }

    @Override
    public List<ImageBean> getAllImages() {

        return converter.convertToBeanList(imagesDao.findBy(), ImageBean.class);
    }

    @Override
    public ImageBean getLastImage() {
       return converter.convertToBean(imagesDao.findTopBy(), ImageBean.class);
    }
}
