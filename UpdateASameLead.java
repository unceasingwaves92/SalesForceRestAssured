package SalesForceRestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UpdateASameLead {
	
	
	@Test
	public void updateASameLead() {
		
		
		RestAssured.baseURI="https://ap16.salesforce.com/services/data/v20.0/sobjects/Lead/00Q2y000002atx0EAA";
		
		
		

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
				.body("{\"Country\" : \"America\"}")
				.patch()
				.then()
				.assertThat()
				.statusCode(204)
				.extract().response();
				
				response.prettyPrint();
				System.out.println(response.getStatusCode());
				
			
				System.out.println(response.getContentType());
				
	}
	

}