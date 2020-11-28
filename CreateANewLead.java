package SalesForceRestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateANewLead {
	
	
	@Test
	public void createANewLead() {
		
		
		RestAssured.baseURI="https://ap16.salesforce.com/services/data/v20.0/sobjects/Lead";
		
	
		
		Response response = RestAssured
				.given()
				.log()
				.all()
				.headers(
			              "Authorization",
			              "Bearer xxx",
			              "Content-Type",
			              ContentType.JSON,
			              "Accept",
			              ContentType.JSON)
				.body("{\"FirstName\" : \"Karthikeyan Kalyana Chidambaram\",\"LastName\" : \"K\", \"Company\" : \"Test Leaf\"}")
				.post()
				.then()
				.assertThat()
				.statusCode(201)
				.extract().response();
				
				response.prettyPrint();
				System.out.println(response.getStatusCode());
				
				JsonPath jsonResponse = response.jsonPath();
				
				String listSysID = jsonResponse.getString("id");
				System.out.println(listSysID);
					
				
				
	}
	

}
