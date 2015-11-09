package com.saralnotes.controllers;

import java.util.Map;

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
import com.saralnotes.repository.UserRepository;

@RestController
//@RequestMapping(value = "/document")
public class UserController {

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	@Autowired
	UserRepository userRepository;
	@Autowired
	RestResponse restResponse;

	

	@RequestMapping(value = "/addUser", method = RequestMethod.POST,consumes="application/json")
	//@ResponseBody
	public RestResponse addUser(
		
			@RequestBody User document) {
		logger.info("inside add * method.");
		//logger.info("Document Name:" + request.getAttribute("documentName"));
		try {
			userRepository.addUser(document);

		} catch (Exception ex) {
			logger.info("got Exception in getting all documents: "
					+ ex.getMessage());
		}
		return restResponse;
	}
	
	
	@RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
	//@ResponseBody
	public RestResponse getUserById(@PathVariable("id") String id) {
		logger.info("inside get user by ID method.");
		try{
		restResponse.setSingleUserResponse(userRepository.getUserByUserId(id));
		}
		catch(Exception exp)
		{
			logger.info("Error in get user by ID"+exp);
		}
		return restResponse;
	}
	
	@RequestMapping(value = "/getUserByCriteria", method = RequestMethod.POST)
	public RestResponse getUserByCriteria(@PathVariable("keyvalue") Map<String, String> key)
	{
		return restResponse;
	}
	
	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public RestResponse getAllUsers()
	{
		logger.info("Inside get all users method.");
		try
		{
		 restResponse.setMutipleUserResponse(userRepository.getAllUsers());
		}
		catch(Exception exp)
		{
			logger.info("Exception in get all users method"+exp);
		}
		return restResponse;
	}
	
	@RequestMapping(value="/deleteUser/{id}",method = RequestMethod.DELETE)
	public RestResponse deleteUSerById(@PathVariable("id") String id)
	{
		logger.info("Inside get delete users method.");
		try
		{
		 restResponse.setSingleUserResponse(userRepository.deleteUser(id));
		}
		catch(Exception exp)
		{
			logger.info("Exception in get delete users method"+exp);
		}
		return restResponse;

	}
	
	@RequestMapping(value="/updateUser/{id}", method=RequestMethod.PUT)
	@ResponseBody
	public RestResponse updateUserByID(@PathVariable("id") String userID, @RequestBody User user) {
		RestResponse extResp;
		try{
		User myUser = userRepository.updateUser(userID, user);
		
		if (myUser != null) {
			logger.info("Inside updateUserByID, updated: " + myUser.toString());
			restResponse = new RestResponse(true, "Successfully updated Issuer: " + myUser.toString());
		} else {
			logger.info("Inside updateUserByID, ticker: " + userID + ", NOT FOUND!");
			restResponse = new RestResponse(false, "Failed to update user: " + userID);
		}
		}
		catch(Exception ex)
		{
			logger.info(ex.toString());
		}
		return restResponse;
	}
	public void setRestResponse(RestResponse restResponse) {
		this.restResponse = restResponse;
	}

	public RestResponse getRestResponse() {
		return restResponse;
	}
	
	

}
