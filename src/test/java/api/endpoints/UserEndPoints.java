package api.endpoints;
import static io.restassured.RestAssured.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//UserEndPoints.java
//Create for perform Create , Read , Update and Delete request the user API.

public class UserEndPoints {

	public static Response createUser(User payload) //take some payloads >> request body
	{
	 Response response=given()
	 	 .contentType(ContentType.JSON)
	 	 .accept(ContentType.JSON)
	 	 .body(payload)
	 	 
	 	.when()
	 	.post(Routes.post_url);
	 	
	 	return response;
	} 
	
	public static Response readUser(String username) //take some payloads >> request body
	{
	 Response response=given()
	 	 .pathParam("username",username)
	 	.when()
	 	.get(Routes.get_url); //get response
	 	
	 	return response;
	} 
	
	public static Response updateUser(String username, User payload) //take some payloads >> request body
	{
	 Response response=given()
	 	 .contentType(ContentType.JSON)
	 	 .accept(ContentType.JSON)
	 	 .pathParam("username", username)
	 	 .body(payload)
	 	 
	 	.when()
	 	.put(Routes.update_url);
	 	
	 	return response;
	
	}
	
	
	public static Response deleteUser(String username) //take some payloads >> request body
	{
	 Response response=given()
	 	 .pathParam("username",username)
	 	.when()
	 	.delete(Routes.delete_url); 
	 	
	 	return response;
}
}