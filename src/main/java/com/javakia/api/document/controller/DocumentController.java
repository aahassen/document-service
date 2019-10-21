package com.javakia.api.document.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javakia.api.document.dao.DocumentDao;
import com.javakia.api.document.model.Document;


@RestController
@CrossOrigin()
public class DocumentController {
	@Autowired
    DocumentDao docDao;
	//@Autowired
	//S3Service s3Service;
	@RequestMapping(value = "/uploadDoc", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("author") String author, @RequestParam("tags") String tags) {
		Document doc = new Document();
		doc.setFileName(file.getOriginalFilename());
		doc.setAuthor(author);
		doc.setTags(tags);
		
		//s3Service.uploadFile(file);
		
		docDao.save(doc);
		
        return "Succesfully uploaded: " + file.getOriginalFilename();
    }
	
	@RequestMapping(value = "/getDocs", method = RequestMethod.GET)
    public List<Document> download() {
		List<Document> allDocs = (List<Document>) docDao.findAll();
        return allDocs;
    }

}
