package com.javakia.api.document.dao;

import org.springframework.data.repository.CrudRepository;

import com.javakia.api.document.model.Document;
import com.javakia.api.document.model.DocumentMetaData;

public interface DocumentDao extends CrudRepository<DocumentMetaData, Integer> {

}
