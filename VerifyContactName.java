package SalesForceRestAssured;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class VerifyContactName {
	
	
	@Test
	public void verifyContactName() {
		
		
		RestAssured.baseURI="https://ap16.salesforce.com/services/data/v20.0/sobjects/Contact";
		
		
		
		Response response = RestAssured
				.given()
				.log()
				.all()
				.headers(
			              "Authorization",
			              "Bearer xxxxx",
			              "Content-Type",
			              ContentType.JSON,
			              "Accept",
			              ContentType.JSON)
				
				.get()
				
				.then()
				.assertThat()
				.statusCode(200)
				.body("recentItems.Id[0]", Matchers.equalTo("0032y000005kbhqAAA"))
				.extract().response();
		
		//Step4: Get Status Code
		System.out.println(response.getStatusCode());
//Step5: Get Content Type
		System.out.println(response.getContentType());
//Step6: Get Response Body
		response.prettyPrint();
		
		JsonPath jsonResponse = response.jsonPath();
		
		String listSysID = jsonResponse.getString("recentItems.Name[0]");
		System.out.println(listSysID);
				
				
				
				
	}
	

}
