package SalesForceRestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Authentication {
	
	
	@Test
	public void authentication() {
		
		
		RestAssured.baseURI="https://ap16.salesforce.com/services/oauth2/token";
		
		Response response = RestAssured
				.given()
				.contentType("application/x-www-form-urlencoded")
				.formParam("Token Name", "post")
				.formParam("username", "xxxx")
				.formParam("password","xxx")   
				.formParam("grant_type", "password")
				.formParam("redirect_uri","https://localhost:8443/RestTest/oauth/_callback")
				.formParam("authorize","https://login.salesforce.com/services/oauth2/authorize")
				.formParam("token", "https://login.salesforce.com/services/oauth2/token")
				.formParam("client_id", "clientID")
				.formParam("client_secret", "secret")
				.formParam("Client Authentication", "Send client credentials in body")
				.post();

		
		
			
				
				response.prettyPrint();
				
			
			
					
				
				
	}
	

}
