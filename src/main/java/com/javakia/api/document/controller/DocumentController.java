package com.javakia.api.document.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javakia.api.document.model.Document;
import com.javakia.api.document.model.DocumentMetaData;
import com.javakia.api.document.service.DocumentService;


@RestController
public class DocumentController {
	@Autowired
    DocumentService docService;
	//@Autowired
	//S3Service s3Service;
	@CrossOrigin("*")
	@RequestMapping(value = "/uploadDoc", method = RequestMethod.POST)
    public void uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("author") String author, @RequestParam("tags") String tags) throws IOException {
		DocumentMetaData metaData = new DocumentMetaData();
		metaData.setFilename(file.getOriginalFilename());
		metaData.setAuthor(author);
		metaData.setTags(tags);
		
		Document doc = new Document();
		doc.setDocumentMetaData(metaData);
		doc.setContent(file.getInputStream());
		
		docService.save(doc);
	
    }
	
	@CrossOrigin("*")
	@RequestMapping(value = "/uploadDoc", method = RequestMethod.GET)
    public List<DocumentMetaData> download(Pageable pagable) {
        return docService.getDocs(pagable).getContent();
    }

}
