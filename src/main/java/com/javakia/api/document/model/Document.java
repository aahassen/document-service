package com.javakia.api.document.model;

import java.io.InputStream;

public class Document {
	  private InputStream content;

	  private DocumentMetaData documentMetaData;

	/**
	 * @return the content
	 */
	public InputStream getContent() {
		return content;
	}

	/**
	 * @return the documentMetaData
	 */
	public DocumentMetaData getDocumentMetaData() {
		return documentMetaData;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(InputStream content) {
		this.content = content;
	}

	/**
	 * @param documentMetaData the documentMetaData to set
	 */
	public void setDocumentMetaData(DocumentMetaData documentMetaData) {
		this.documentMetaData = documentMetaData;
	}
	  
	  

}
