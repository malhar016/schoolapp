package com.saralnotes.model;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.saralnotes.util.GroupTypes;


@Document
public class Group {

	@Id
	private String id;
	private String groupName;
	private String groupCode;
	private ArrayList<String> members;
	private String createdBy;
	private Date createTime;
	private GroupTypes groupTypes;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public ArrayList<String> getMembers() {
		return members;
	}
	public void setMembers(ArrayList<String> members) {
		this.members = members;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public GroupTypes getGroupTypes() {
		return groupTypes;
	}
	public void setGroupTypes(GroupTypes groupTypes) {
		this.groupTypes = groupTypes;
	}
	
}
