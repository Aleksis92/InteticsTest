package com.latyshonak.service.impl.dozer.converters;



import com.latyshonak.dao.Entity.Users;
import com.latyshonak.dao.UsersDao;
import org.dozer.DozerConverter;
import org.springframework.beans.factory.annotation.Autowired;


public class ImagesCreatorConverter  extends DozerConverter<Users, String> {

        @Autowired
        private UsersDao userDao;

        public ImagesCreatorConverter() {
            super(Users.class, String.class);
        }

        @Override
        public String convertTo(Users source, String destination) {
            return source.getEmail();
        }

        @Override
        public Users convertFrom(String source, Users destination) {
            Users user = userDao.findByEmail(source);
            return user;
        }

    }

