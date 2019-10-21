package com.javakia.api.document.dao;

import org.springframework.data.repository.CrudRepository;

import com.javakia.api.document.model.Document;

public interface DocumentDao extends CrudRepository<Document, Integer> {

}
