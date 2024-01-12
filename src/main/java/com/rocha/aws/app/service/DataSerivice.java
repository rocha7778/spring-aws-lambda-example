package com.rocha.aws.app.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.fasterxml.jackson.databind.JsonNode;
import com.rocha.aws.app.secret.manager.AWSSecretsManagerUtil;

@Service
public class DataSerivice {

	private AmazonDynamoDB amazonDynamoDB;
	private String DYNAMODB_TABLE_NAME = "UserNote";
	private static Regions REGION = Regions.US_EAST_2;

	public DataSerivice() {
		initDynamoDbClient();
	}

	public void initDynamoDbClient() {
		
		//JsonNode awsCredentials = AWSSecretsManagerUtil.getAWSCredentialsFromSecretsManager("dynamodb-access","us-east-2");
		
		//String accessKey = awsCredentials.get("accessKey").asText();
		//String secretKey = awsCredentials.get("secretKey").asText();
		
		//System.out.println(accessKey);
		//System.out.println(secretKey);

		//BasicAWSCredentials awsSecret = new BasicAWSCredentials(accessKey, secretKey);
		

		this.amazonDynamoDB = AmazonDynamoDBClientBuilder
				.standard()
				.withRegion(REGION)
				//.withCredentials(new AWSStaticCredentialsProvider(awsSecret))
				.build();
	}

	public void persistData() throws ConditionalCheckFailedException {

		Map<String, AttributeValue> attributesMap = new HashMap<>();

		attributesMap.put("id", new AttributeValue("73216158"));
		attributesMap.put("text", new AttributeValue("Carlos Gutierrez"));

		amazonDynamoDB.putItem(DYNAMODB_TABLE_NAME, attributesMap);
	}



}
