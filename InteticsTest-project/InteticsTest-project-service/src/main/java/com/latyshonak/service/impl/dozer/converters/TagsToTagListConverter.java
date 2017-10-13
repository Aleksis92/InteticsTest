package com.latyshonak.service.impl.dozer.converters;

import com.latyshonak.dao.Entity.Images;
import com.latyshonak.dao.Entity.Tags;
import com.latyshonak.dao.TagsDao;
import com.latyshonak.dao.UsersDao;
import com.latyshonak.service.beans.ImageBean;
import org.dozer.DozerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TagsToTagListConverter extends DozerConverter<ImageBean, Images> {

    @Autowired
    private TagsDao dao;

    @Autowired
    private UsersDao usersDao;

    public TagsToTagListConverter() {
        super(ImageBean.class, Images.class);
    }

    @Override
    public Images convertTo(ImageBean source, Images destination) {
        Images image = new Images();

        image.setId(source.getId());;
        image.setImage(source.getImage());
        image.setName(source.getName());
        image.setDescription(source.getDescription());
        image.setCreator(usersDao.findByEmail(source.getCreatedBy()));
        image.setTags(createTagsListForImage(source, image));


        return image;
    }

    @Override
    public ImageBean convertFrom(Images source, ImageBean destination) {
        ImageBean bean = new ImageBean();

        bean.setId(source.getId());;
        bean.setImage(source.getImage());
        bean.setName(source.getName());
        bean.setDescription(source.getDescription());
        bean.setTags(createTagsStrForBean(source));

        return bean;
    }

    private List<Tags> createTagsListForImage(ImageBean source, Images result) {
        String[] tagsArray = source.getTags().split(" ");
        List<Tags> tagList = new ArrayList<>();

        for (String tagStr : tagsArray) {
            Tags tag = dao.findByTag(tagStr);
            if (tag == null) {
                tag = new Tags();
                tag.setTag(tagStr);
            }

            tag.addImage(result);
            tagList.add(tag);
        }

        return tagList;
    }

    private String createTagsStrForBean(Images source) {
        StringBuilder builder = new StringBuilder();
        List<Tags> tags = source.getTags();
        for (Tags tag : tags) {
            String tagStr =tag.getTag();
            if (builder.length() != 0) {
                builder.append(" ");
                builder.append(tagStr);
            }
        }

        return builder.toString();
    }
}

