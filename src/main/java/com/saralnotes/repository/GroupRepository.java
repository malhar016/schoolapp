package com.saralnotes.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.saralnotes.model.Group;
import com.saralnotes.util.GroupTypes;

@Repository
public class GroupRepository {

	public static final String Collection_Name = "groups";

	@Autowired
	MongoTemplate mongoTemplate;

	public void addGroup(Group group) {
		if (!mongoTemplate.collectionExists(Group.class)) {
			mongoTemplate.createCollection(Group.class);
		} else {
			mongoTemplate.insert(Group.class, Collection_Name);
		}

	}

	public Group getGroupByGroupId(String groupId) {
		return mongoTemplate.findOne(
				Query.query(Criteria.where("id").is(groupId)), Group.class,
				Collection_Name);
	}

	public List<Group> getAllGroups() {
		return mongoTemplate.findAll(Group.class, Collection_Name);
	}
	
	
	public Group deleteGroup(String groupId)
	{
		Group group = getGroupByGroupId(groupId);
		mongoTemplate.remove(group,Collection_Name);
		return group;
	}
	
	
	public Group updateGroup(String groupId, Group group)
	{
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(groupId));
		Update update = new Update();
		update.set("groupName", group.getGroupName());
		update.set("groupCode", group.getGroupCode());
		update.set("groupTypes", group.getGroupTypes());
		update.set("members", group.getMembers());
		update.set("createdBy", group.getCreatedBy());
		update.set("createTime", group.getCreateTime());
		mongoTemplate.updateFirst(query, update, Collection_Name);
		
		return group;
	}
	
	
}