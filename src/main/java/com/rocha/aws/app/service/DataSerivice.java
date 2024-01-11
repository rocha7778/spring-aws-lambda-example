package com.rocha.aws.app.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;

@Service
public class DataSerivice {

	private AmazonDynamoDB amazonDynamoDB;
	private String DYNAMODB_TABLE_NAME = "UserNote";
	private Regions REGION = Regions.US_WEST_2;

	public DataSerivice() {
		initDynamoDbClient();
	}

	public void initDynamoDbClient() {
		this.amazonDynamoDB = AmazonDynamoDBClientBuilder.standard().withRegion(REGION).build();
	}

	public void persistData() throws ConditionalCheckFailedException {

		Map<String, AttributeValue> attributesMap = new HashMap<>();

		attributesMap.put("id", new AttributeValue("73216158"));
		attributesMap.put("text", new AttributeValue("Carlos Gutierrez"));

		amazonDynamoDB.putItem(DYNAMODB_TABLE_NAME, attributesMap);
	}

}
