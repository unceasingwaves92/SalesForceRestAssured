package SalesForceRestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UpdateASameContact {
	
	
	@Test
	public void updateASameContact() {
		
		
		RestAssured.baseURI="https://ap16.salesforce.com/services/data/v20.0/sobjects/Contact/";
		
		
		
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
				.pathParam("id", "0032y000005kbhqAAA")
				.body("{\"OtherStreet\" : \"eldams road\",\"OtherCity\" : \"Johaneesburg\"}")
				
				.patch("{id}")
				.then()
				.assertThat()
				.statusCode(204)
				.extract().response();
		
		//Step4: Get Status Code
		System.out.println(response.getStatusCode());
//Step5: Get Content Type
		System.out.println(response.getContentType());
//Step6: Get Response Body
		response.prettyPrint();
		
		
				
				
				
				
	}
	

}
