package com.saralnotes.repository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.saralnotes.model.User;


@Repository
public class UserRepository {


		public static final String COLLECTION_NAME = "user";
		
		@Autowired
	    private MongoTemplate mongoTemplate;
		
		public void addUser(User user) {
	        if (!mongoTemplate.collectionExists(user.getClass())) {
	            mongoTemplate.createCollection(user.getClass());
	        }       
	        mongoTemplate.insert(user, COLLECTION_NAME);
	    }
		
		public User getUserByUserId(String userId) {
		    return mongoTemplate.findOne(
		    		Query.query(Criteria.where("id").is(userId)), User.class, COLLECTION_NAME);
		}
		
		public List<User> getAllUsers() {
	        return mongoTemplate.findAll(User.class, COLLECTION_NAME);
	    }
	     
	    public User deleteUser(String userId) {
	    	User user = mongoTemplate.findOne(
		    		Query.query(Criteria.where("id").is(userId)), User.class, COLLECTION_NAME);
	        mongoTemplate.remove(user, COLLECTION_NAME);
	        return user;
	    }
	    
	    public User updateUser(String userId, User user) {
	    	Query query = new Query();
			query.addCriteria(Criteria.where("id").is(userId));
			//query.fields().include("userName");

			User userTest3 = mongoTemplate.findOne(query, User.class);
			System.out.println("userTest3 - " + userTest3);
			
	 
			Update update = new Update();
			update.set("userName", user.getUserName());
			update.set("phoneNumber",user.getPhoneNumber());
			update.set("emailId",user.getEmailId());
			update.set("password",user.getPassword());
			update.set("isSmsEnabled",user.isSmsEnabled());
			update.set("deviceId",user.getDeviceId());
	        mongoTemplate.updateFirst(query, update, User.class);
	        
	        return user;
	    }
	}

	

