package com.latyshonak.dao;

import com.latyshonak.dao.Entity.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoleDao extends PagingAndSortingRepository<Role, Integer> {
}
