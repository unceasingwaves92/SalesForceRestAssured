package SalesForceRestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateANewContact {
	
	
	@Test
	public void createANewContact() {
		
		
		RestAssured.baseURI="https://ap16.salesforce.com/services/data/v20.0/sobjects/Contact";
		
		
		
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
				.body("{\"FirstName\" : \"Karthikeyan\",\"LastName\" : \"Tester\"}")
				.post();
				
				response.prettyPrint();
				System.out.println(response.getStatusCode());
				
				JsonPath jsonResponse = response.jsonPath();
				
				String listSysID = jsonResponse.getString("id");
				System.out.println(listSysID);
					
				
				
	}
	

}
