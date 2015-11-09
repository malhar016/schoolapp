package com.saralnotes.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.saralnotes.model.RestResponse;
import com.saralnotes.model.User;
import com.saralnotes.repository.DocumentRepository;

@RestController
//@RequestMapping(value = "/document")
public class RestDAOController {

	/*@Autowired
	DocumentRepository documentRepository;
	@Autowired
	RestResponse restResponse;
	private static final Logger logger = LoggerFactory
			.getLogger(RestDAOController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePing() {
		logger.info("In side home action.");
		return "status";
	}

	@RequestMapping(value = "/get/{documentName}")
	public RestResponse getAllDocuments(
			@PathVariable("documentName") String documentName) {
		logger.info("inside get * method.");
		logger.info("Document Name:" + documentName);
		try {
			restResponse.setResponseObj(documentRepository.getAllDocuments(
					Class.forName("com.saralnotes.model." + documentName),
					documentName.toLowerCase() + "s"));
		} catch (Exception ex) {
			logger.info("got Exception in getting all documents: "
					+ ex.getMessage());
		}
		return restResponse;
	}

	@RequestMapping(value = "/add/{documentName}", method = RequestMethod.POST)
	//@ResponseBody
	public void addDocuments(
			@PathVariable("documentName") String documentName,HttpServletResponse response
			, HttpServletRequest request) {
		logger.info("inside add * method.");
		logger.info("Document Name:" + documentName);
		try {
			String url = request.getContextPath();
			request.setAttribute("documentName", documentName);
			response.sendRedirect("/SaralNotesRestService/rest/document/add" + documentName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public DocumentRepository getDocumentRepository() {
		return documentRepository;
	}

	public void setDocumentRepository(DocumentRepository documentRepository) {
		this.documentRepository = documentRepository;
	}

	public RestResponse getRestResponse() {
		return restResponse;
	}

	public void setRestResponse(RestResponse restResponse) {
		this.restResponse = restResponse;
	}
*/

}
