package com.javakia.api.document.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.javakia.api.document.model.DocumentMetaData;

public interface DocumentDao extends PagingAndSortingRepository<DocumentMetaData, Integer> {
	Page<DocumentMetaData> findAll(Pageable pageable);

}
