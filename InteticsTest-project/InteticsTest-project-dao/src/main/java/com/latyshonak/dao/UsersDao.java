package com.latyshonak.dao;

import com.latyshonak.dao.Entity.Users;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsersDao extends PagingAndSortingRepository<Users, Integer>{

    Users findByLogin (String login);

}