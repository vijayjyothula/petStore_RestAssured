package api.EndPoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.PayLoad.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userEndPoints {


	@Test
	
	public static Response userCreates(User payLoad)
	{
		
		Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payLoad)
		
		.when()
		.post(Routes.post_url);
		
		return response;
	}
	
	@Test
	
	public static Response read_User(String username)
	{
		
		Response response = given()
		.pathParam("username", username)
		
		.when()
		.get(Routes.read_url);
		return response;
	}
	
	@Test()
	
	public static Response update_User(String username, User payLoad)
	{
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", username)
				.body(payLoad)
				
				.when()
				.put(Routes.update_url);
		return response;
	}
	
	@Test()
	
	public static Response delete_User(String username)
	{
		Response response = given()
				.pathParam("username", username)
				
				.when()
				.delete(Routes.delete_url);
		return response;
	}
	
}
