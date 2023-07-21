package com.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import api.EndPoints.userEndPoints;
import com.github.javafaker.Faker;
import api.PayLoad.User;
import io.restassured.response.Response;

public class petStoreUserTest {
	
	Faker faker = new Faker();
	User payLoad = new User();
	
	@BeforeClass
	public void setupData()
	{
		payLoad.setId(faker.idNumber().hashCode());
		payLoad.setUsername(faker.name().username());
		payLoad.setFirstName(faker.name().firstName());
		payLoad.setLastName(faker.name().lastName());
		payLoad.setEmail(faker.internet().safeEmailAddress());
		payLoad.setPassword(faker.internet().password(5, 10));
		payLoad.setPhone(faker.phoneNumber().cellPhone());
	}
	
	@Test(priority = 0)
	
	public void post_U()
	{
		Response response = userEndPoints.userCreates(payLoad);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 1)
	
	public void get_u()
	{
		Response response = userEndPoints.read_User(payLoad.getUsername());
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 2)
	
	public void update_u()
	{	
		payLoad.setFirstName(faker.name().firstName());
		payLoad.setLastName(faker.name().lastName());
		payLoad.setEmail(faker.internet().safeEmailAddress());
	
		Response resposne = userEndPoints.update_User(this.payLoad.getUsername(), payLoad);
		resposne.then().log().all();
		Assert.assertEquals(resposne.getStatusCode(), 200);
		
	}
	
	@Test(priority = 3)
	
	public void delete_U()
	{
		Response response = userEndPoints.delete_User(payLoad.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
}
