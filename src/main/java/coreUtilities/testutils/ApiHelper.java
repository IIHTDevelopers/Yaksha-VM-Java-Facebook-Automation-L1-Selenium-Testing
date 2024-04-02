package coreUtilities.testutils;

import java.net.MalformedURLException;
import java.net.URL;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiHelper {
	
	public Response getRequest(String endPoint) throws MalformedURLException
	{
		return RestAssured.given()
							.when()
							.get(new URL(endPoint));
	}
	
	public boolean isValidUrl(String endPoint) throws Exception {
		try {
			Response response = RestAssured.given()
			.relaxedHTTPSValidation()
			.when()
			.get(new URL(endPoint));
			if(response.getStatusCode()>=400)
				return false;
			else 
				return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	
}
