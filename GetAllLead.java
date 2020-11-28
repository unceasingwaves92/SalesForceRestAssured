package SalesForceRestAssured;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllLead {
	
	
	@Test
	public void getAllLead() {
		
		
		RestAssured.baseURI="https://ap16.salesforce.com/services/data/v20.0/sobjects/Lead";
		
		
		
		Response response = RestAssured
				.given()
				.log()
				.all()
				.headers(
			              "Authorization",
			              "Bearer xxxx",
			              "Content-Type",
			              ContentType.JSON,
			              "Accept",
			              ContentType.JSON)
				
				.get()
				.then()
				.assertThat()
				.statusCode(200)
				.body("result.id", Matchers.not("00Q2y000002atx0EAA"))
				.extract().response();
				
				response.prettyPrint();
				System.out.println(response.getStatusCode());
				
			
				System.out.println(response.getContentType());
				
				JsonPath jsonResponse = response.jsonPath();
				
				
				
	}
	

}
