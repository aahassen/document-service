package com.javakia.api.document.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.javakia.api.document.dao.DocumentDao;
import com.javakia.api.document.model.Document;
import com.javakia.api.document.model.DocumentMetaData;


@Service
public class DocumentService {
	@Autowired
	private DocumentDao docDao;
	
	@Value("${document.uploadDir}")
	private String uploadDir;

	public void save(Document doc) throws IOException {
	
	
	Files.copy(doc.getContent(), Paths.get(uploadDir, doc.getDocumentMetaData().getFilename()), StandardCopyOption.REPLACE_EXISTING);
	//TODO: Avoid dup entry
	docDao.save(doc.getDocumentMetaData());
	}
	
	public Page<DocumentMetaData> getDocs(Pageable pagable)
	{
		Page<DocumentMetaData> allDocs = docDao.findAll(pagable);
        return allDocs;
	}

}
