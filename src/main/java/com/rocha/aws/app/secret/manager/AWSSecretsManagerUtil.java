package com.rocha.aws.app.secret.manager;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

public class AWSSecretsManagerUtil {

	public static JsonNode getAWSCredentialsFromSecretsManager(String secretName, String region) {
		
		
		SecretsManagerClient secretsManagerClient = SecretsManagerClient.builder()
				.region(Region.of(region)).build();

		GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder().secretId(secretName).build();
		GetSecretValueResponse getSecretValueResponse = secretsManagerClient.getSecretValue(getSecretValueRequest);

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = null;

		try {
			jsonNode = objectMapper.readTree(getSecretValueResponse.secretString());
		} catch (Exception e) {
		}

		

		return  jsonNode;
	}

}
