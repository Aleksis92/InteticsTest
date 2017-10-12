package com.latyshonak.dao;

import com.latyshonak.dao.Entity.Images;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ImagesDao extends PagingAndSortingRepository<Images, Integer>{

    List<Images> findBy();

    Images findTopBy();


}