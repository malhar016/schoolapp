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

import com.saralnotes.model.Group;
import com.saralnotes.model.RestResponse;
import com.saralnotes.repository.GroupRepository;

public class GroupController {
	private static final Logger logger = LoggerFactory
			.getLogger(GroupController.class);

	@Autowired
	GroupRepository groupRepository;
	@Autowired
	RestResponse restResponse;

	@RequestMapping(value = "/addGroup", method = RequestMethod.POST,consumes="application/json")
	//@ResponseBody
	public RestResponse addGroup(
		
			@RequestBody Group group) {
		logger.info("inside addGroup * method.");
		//logger.info("Document Name:" + request.getAttribute("documentName"));
		try {
			groupRepository.addGroup(group);

		} catch (Exception ex) {
			logger.info("got Exception in getting all documents: "
					+ ex.getMessage());
		}
		return restResponse;
	}
	
	
	@RequestMapping(value = "/getGroupById/{id}", method = RequestMethod.GET)
	//@ResponseBody
	public RestResponse getUserById(@PathVariable("id") String id) {
		logger.info("inside get group by ID method.");
		try{
		restResponse.setSingleGroupResponse(groupRepository.getGroupByGroupId(id));
		}
		catch(Exception exp)
		{
			logger.info("Error in get group by ID"+exp);
		}
		return restResponse;
	}
	//need to work on this..
	@RequestMapping(value = "/getGroupByCriteria", method = RequestMethod.POST)
	public RestResponse getUserByCriteria(@PathVariable("keyvalue") Map<String, String> key)
	{
		return restResponse;
	}
	
	
	@RequestMapping(value = "/getAllGroups", method = RequestMethod.GET)
	public RestResponse getAllUsers()
	{
		logger.info("Inside get all groups method.");
		try
		{
		 restResponse.setMultipleGroupResponse(groupRepository.getAllGroups());
		}
		catch(Exception exp)
		{
			logger.info("Exception in get all groups method"+exp);
		}
		return restResponse;
	}
	
	@RequestMapping(value="/deleteGroup/{id}",method = RequestMethod.DELETE)
	public RestResponse deleteGroupById(@PathVariable("id") String id)
	{
		logger.info("Inside get delete group method.");
		try
		{
		 restResponse.setSingleGroupResponse(groupRepository.deleteGroup(id));
		}
		catch(Exception exp)
		{
			logger.info("Exception in get delete group method"+exp);
		}
		return restResponse;

	}
	
	@RequestMapping(value="/updateGroup/{id}", method=RequestMethod.PUT)
	@ResponseBody
	public RestResponse updateUserByID(@PathVariable("id") String groupID, @RequestBody Group group) {
		RestResponse extResp;
		try{
		Group myGroup = groupRepository.updateGroup(groupID,group);
		
		if (myGroup != null) {
			logger.info("Inside updateUserByID, updated: " + myGroup.toString());
			restResponse = new RestResponse(true, "Successfully updated Issuer: " + myGroup.toString());
		} else {
			logger.info("Inside updateUserByID, ticker: " + groupID + ", NOT FOUND!");
			restResponse = new RestResponse(false, "Failed to update user: " + groupID);
		}
		}
		catch(Exception ex)
		{
			logger.info(ex.toString());
		}
		return restResponse;
	}


	public RestResponse getRestResponse() {
		return restResponse;
	}


	public void setRestResponse(RestResponse restResponse) {
		this.restResponse = restResponse;
	}
	
	

}
