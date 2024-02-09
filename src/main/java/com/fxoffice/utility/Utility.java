package com.fxoffice.utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Set;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Utility {
	
	public void getAccessToken(String tokenEnv) throws FileNotFoundException, IOException, ParseException {
		
		try(InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("EnvironmentConfigProperties.json")){
	    		/* Pass InputStream to JSON-Library i.e., using Jackson */
	    	    ObjectMapper mapper = new ObjectMapper();
	    	    JsonNode jsonNode = mapper.readValue(in, JsonNode.class);
	    	    String jsonString = mapper.writeValueAsString(jsonNode);

	    	    JSONParser parser = new JSONParser();
	    	    JSONObject json = (JSONObject) parser.parse(jsonString);

	    	    Set<?> keys = json.keySet();
	    	    Iterator<?> envType = keys.iterator();
   	    
	    	    while(envType.hasNext()) {
	    	        String envName = envType.next().toString();
	    	        if(envName.equals(tokenEnv)) {
	    	        	   JSONObject environment = (JSONObject) json.get(envName);
	    	        	   Set<?> jsonEnvironmentObjectKeys = environment.keySet();
	    		    	   Iterator<?> envParametersIterator = jsonEnvironmentObjectKeys.iterator();
	    		    	   while(envParametersIterator.hasNext()) {
	    		    	        String envParameterKeyName = envParametersIterator.next().toString();
	    		    	        String envParameterKeyValueName = (String) environment.get(envParameterKeyName);
	    		    	        ParameterService.setParameter(tokenEnv+envParameterKeyName, envParameterKeyValueName);
	    		    	   }
	    	        }
	    	    }

	    	    String apikey =  ParameterService.getParameter(tokenEnv+"apikey");
	    	    String apisecret = ParameterService.getParameter(tokenEnv+"apisecret");
	    	    String baseurl = ParameterService.getParameter(tokenEnv+"tokenurl");
	    	    String tenant = ParameterService.getParameter(tokenEnv+"tenant");
	    	    String tokenBaseURI = baseurl+"/auth/realms/"+tenant+"/protocol/openid-connect/token";

	    	    RestAssured.authentication = RestAssured.preemptive()
									.basic(apikey, apisecret);

	    	    Response response =(Response) RestAssured.given()
							.header("Accept", "application/vnd.api+json")
							.header("ContentType", "application/json")
							.param("grant_type", "client_credentials")
							.log().all()
							.post(tokenBaseURI)
							.then().extract().response();

	    	    String accessToken = response.getBody().path("access_token").toString();
	    	    ParameterService.setParameter(tokenEnv+"AccessToken", accessToken);
		}
	}

	public void getProperty(String tokenEnv) throws FileNotFoundException, IOException, ParseException {
		
		try(InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("BlkUploadEnvironmentConfigProperties.json")){
	    		/* Pass InputStream to JSON-Library i.e., using Jackson */
	    	    ObjectMapper mapper = new ObjectMapper();
	    	    JsonNode jsonNode = mapper.readValue(in, JsonNode.class);
	    	    String jsonString = mapper.writeValueAsString(jsonNode);

	    	    JSONParser parser = new JSONParser();
	    	    JSONObject json = (JSONObject) parser.parse(jsonString);

	    	    Set<?> keys = json.keySet();
	    	    Iterator<?> envType = keys.iterator();
   	    
	    	    while(envType.hasNext()) {
	    	        String envName = envType.next().toString();
	    	        if(envName.equals(tokenEnv)) {
	    	        	   JSONObject environment = (JSONObject) json.get(envName);
	    	        	   Set<?> jsonEnvironmentObjectKeys = environment.keySet();
	    		    	   Iterator<?> envParametersIterator = jsonEnvironmentObjectKeys.iterator();
	    		    	   while(envParametersIterator.hasNext()) {
	    		    	        String envParameterKeyName = envParametersIterator.next().toString();
	    		    	        String envParameterKeyValueName = (String) environment.get(envParameterKeyName);
	    		    	      
	    		    	        ParameterService.setParameter(tokenEnv+envParameterKeyName, envParameterKeyValueName);
	    		    	   }
	    	        }
	    	    }	   
		}
		
		try(InputStream in1=Thread.currentThread().getContextClassLoader().getResourceAsStream("UIEnvironmentConfigProperties.json")){
    		/* Pass InputStream to JSON-Library i.e., using Jackson */
    	    ObjectMapper mapper = new ObjectMapper();
    	    JsonNode jsonNode = mapper.readValue(in1, JsonNode.class);
    	    String jsonString = mapper.writeValueAsString(jsonNode);

    	    JSONParser parser = new JSONParser();
    	    JSONObject json = (JSONObject) parser.parse(jsonString);

    	    Set<?> keys = json.keySet();
    	    Iterator<?> envType = keys.iterator();
	    
    	    while(envType.hasNext()) {
    	        String envName = envType.next().toString();
    	        if(envName.equals(tokenEnv)) {
    	        	   JSONObject environment = (JSONObject) json.get(envName);
    	        	   Set<?> jsonEnvironmentObjectKeys = environment.keySet();
    		    	   Iterator<?> envParametersIterator = jsonEnvironmentObjectKeys.iterator();
    		    	   while(envParametersIterator.hasNext()) {
    		    	        String envParameterKeyName = envParametersIterator.next().toString();
    		    	        String envParameterKeyValueName = (String) environment.get(envParameterKeyName);
    		    	        ParameterService.setParameter(tokenEnv+envParameterKeyName, envParameterKeyValueName);
    		    	   }
    	        }
    	    }	   
	}
		
		
	}
	
}