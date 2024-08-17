package api.test;

import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests2 {
	
	Faker faker; //JavaFaker is a library that can be used to generate a wide array of real-looking data from addresses to popular culture references.
	User userPayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setupData()
	
	{
		
	faker=new Faker();
	userPayload = new User(); // this will generate the data
	
	
	userPayload.setId(faker.idNumber().hashCode());
	userPayload.setUsername(faker.name().username());
	userPayload.setFirstName(faker.name().firstName());
	userPayload.setLastName(faker.name().lastName());
	userPayload.setEmail(faker.internet().safeEmailAddress());
	userPayload.setPassword(faker.internet().password(5, 10));
	userPayload.setPhone(faker.phoneNumber().cellPhone());
	
	//logs
	logger= LogManager.getLogger(this.getClass());
	logger.debug("debuging**************");
	}
	
	@Test(priority=1)

	public void testPostUser()
	
	{
		logger.info("******************** Creating User **********************");
		Response response=UserEndPoints2.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
		
		logger.info("******************** User is created **********************");
	}
	
	@Test(priority=2)

	public void testGetUserByName()
	{
		logger.info("******************** Reading User Info **********************");
		Response response=UserEndPoints2.readUser(this.userPayload.getUsername());
		response.then().log().all();
		//response.statusCode();
		Assert.assertEquals(response.getStatusCode(),200);
		
		logger.info("******************** User Info is Displayed **********************");
		
	}
	
	@Test(priority=3)
	
	public void testUpdateUserByName()
	{
		
		logger.info("******************** Updating User **********************");
	//update data using payload
	userPayload.setFirstName(faker.name().firstName());
	userPayload.setLastName(faker.name().lastName());
	userPayload.setEmail(faker.internet().safeEmailAddress());
	
	Response response=UserEndPoints2.updateUser(this.userPayload.getUsername(),userPayload);
	response.then().log().body(); // both are same -- status code validation
	
	Assert.assertEquals(response.getStatusCode(),200); // both are same -- status code validation
	
	logger.info("******************** User is updated **********************");
	
	//Checking data after updatation
	Response responsAfterupdate=UserEndPoints2.readUser(this.userPayload.getUsername());
		Assert.assertEquals(responsAfterupdate.getStatusCode(),200);
}
	@Test(priority=4)
	public void testDeleteUserByName()
	{
		
		logger.info("**************** Deleting User **********************");
		Response response=UserEndPoints2.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
		
		logger.info("******************** User deleted **********************");
	}
}