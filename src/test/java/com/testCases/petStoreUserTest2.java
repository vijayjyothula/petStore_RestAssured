package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import api.PayLoad.User;
import api.EndPoints.userEndPoints;
import io.restassured.response.Response;

public class petStoreUserTest2 {
	
	User payLoad = new User();
	
	@Test(priority = 0, dataProvider = "pet_User", dataProviderClass = api.Utilities.user_Utilities.class)
	
	public void post_User(String id, String username, String firstname, String lastname, String email, String password, String phone)
	{
	//	payLoad.setId(Integer.parseInt(id));
		payLoad.setUsername(username);
		payLoad.setFirstName(firstname);
		payLoad.setLastName(lastname);
		payLoad.setEmail(email);
		payLoad.setEmail(email);
		payLoad.setPhone(phone);
		
		Response response = userEndPoints.userCreates(payLoad);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 1, dataProvider = "pet_User", dataProviderClass = api.Utilities.user_Utilities.class)
	
	public void get_User(String id, String username, String firstname, String lastname, String email, String password, String phone)
	{
		Response response = userEndPoints.read_User(username);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 2, dataProvider = "pet_User", dataProviderClass = api.Utilities.user_Utilities.class)
	
	public void update_User(String id, String username, String firstname, String lastname, String email, String password, String phone)
	{
		payLoad.setFirstName("Luis");
		payLoad.setLastName("Phillips");
		payLoad.setEmail("abc@gmail.com");
		
		Response response = userEndPoints.update_User(username, payLoad);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 3, dataProvider = "pet_User", dataProviderClass = api.Utilities.user_Utilities.class)
	
	public void delete_User(String id, String username, String firstname, String lastname, String email, String password, String phone)
	{
		Response response = userEndPoints.delete_User(username);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
