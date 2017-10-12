package com.latyshonak.dao;

import com.latyshonak.dao.Entity.Images;
import com.latyshonak.dao.Entity.Tags;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TagsDao extends PagingAndSortingRepository<Tags, Integer> {
}
