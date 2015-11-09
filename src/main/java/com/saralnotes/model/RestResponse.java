package com.saralnotes.model;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="request",proxyMode=ScopedProxyMode.TARGET_CLASS)
public class RestResponse {

	boolean status;
	String message;
	User singleUserResponse;
	Group singleGroupResponse;
	List<User> mutipleUserResponse;
	List<Group> multipleGroupResponse;
	public RestResponse()
	{}
	
	public RestResponse(boolean status, String message) {
		this.status = status;
		this.message = message;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public User getSingleUserResponse() {
		return singleUserResponse;
	}

	public void setSingleUserResponse(User singleUserResponse) {
		this.singleUserResponse = singleUserResponse;
	}

	public Group getSingleGroupResponse() {
		return singleGroupResponse;
	}

	public void setSingleGroupResponse(Group singleGroupResponse) {
		this.singleGroupResponse = singleGroupResponse;
	}

	public List<User> getMutipleUserResponse() {
		return mutipleUserResponse;
	}

	public void setMutipleUserResponse(List<User> mutipleUserResponse) {
		this.mutipleUserResponse = mutipleUserResponse;
	}

	public List<Group> getMultipleGroupResponse() {
		return multipleGroupResponse;
	}

	public void setMultipleGroupResponse(List<Group> multipleGroupResponse) {
		this.multipleGroupResponse = multipleGroupResponse;
	}
	
	
	
	
}
