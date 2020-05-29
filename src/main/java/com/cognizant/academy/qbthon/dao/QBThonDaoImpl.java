package com.cognizant.academy.qbthon.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ResourceInUseException;
import com.cognizant.academy.qbthon.model.Events;
import com.cognizant.academy.qbthon.model.Questions;
import com.cognizant.academy.qbthon.model.Users;

@Component
public class QBThonDaoImpl implements QBThonDao {

	@Autowired
	private DynamoDBMapper dynamoDBMapper;
	
	@Autowired 
	private AmazonDynamoDB amazonDynamoDB;
	 

	public void createEventsTable() throws Exception {

		try {
			dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

			CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(Events.class);

			tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));

			amazonDynamoDB.createTable(tableRequest);
		} catch (ResourceInUseException e) { 
			// Do nothing, table already created
		}
	}


	@Override
	public void createQuestionsTable() throws Exception {
		try {
			dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

			CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(Questions.class);

			tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));

			amazonDynamoDB.createTable(tableRequest);
		} catch (ResourceInUseException e) { 
			// Do nothing, table already created
		}		
	}


	@Override
	public void createUsersTable() throws Exception {
		try {
			dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

			CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(Users.class);

			tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));

			amazonDynamoDB.createTable(tableRequest);
		} catch (ResourceInUseException e) { 
			// Do nothing, table already created
		}			
	}
}
