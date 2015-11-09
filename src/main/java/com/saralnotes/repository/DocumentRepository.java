package com.saralnotes.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.saralnotes.model.Group;
import com.saralnotes.model.User;


@Repository
public class DocumentRepository {

	@Autowired
    private MongoTemplate mongoTemplate;
	
	public List<User> getAllUsers() {
		  return mongoTemplate.findAll(User.class, "users");
	}
	
	public <T> List<T> getAllDocuments(Class<T> document,String collectionName) {
		  return (List<T>) mongoTemplate.findAll(document, collectionName);
	}

	
	public void addUser(User user) {
        if (!mongoTemplate.collectionExists(User.class)) {
            mongoTemplate.createCollection(User.class);
        }       
        mongoTemplate.insert(user, "users");
    }
	
	public <T> void addDocument(Class<T> document,String collectionName) {
        if (!mongoTemplate.collectionExists(document)) {
            mongoTemplate.createCollection(document);
        }       
        mongoTemplate.insert(document, collectionName);
    }
	
	public void addGroup(Group group) {
        if (!mongoTemplate.collectionExists(Group.class)) {
            mongoTemplate.createCollection(Group.class);
        }       
        mongoTemplate.insert(group, "groups");
    }
	
	public <T> void addDocument(T document,String collectionName) {
        if (!mongoTemplate.collectionExists(document.getClass())) {
            mongoTemplate.createCollection(document.getClass());
        }       
        mongoTemplate.insert(document, collectionName);
    }
	
	 public <T>T updateIssuer(String conditionParam,String conditionValue, T document) {
	    	Query query = new Query();
			query.addCriteria(Criteria.where(conditionParam).is(conditionValue));
	 
			Update update = new Update();
			//update.set("issuerName", document.getIssuerName());
			//update.set("issuerType", document.getIssuerType());
			//update.set("country", document.getCountry());
	 
	        mongoTemplate.updateFirst(query, update, document.getClass());
	        
	        return document;
	    }

	
}
