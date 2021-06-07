package get_Request;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.Createuser;
import pojo.Data;
import pojo.GetUser;


public class Req_Test1 {
	public String url="https://reqres.in/api/users?page=1";
	//@Test
	public void getuser() {
		
		given()
		//.pathParam("page", "0")
		.when()
		.get("https://reqres.in/api/users?page=1")
		.then()
		.statusCode(200)
		.assertThat().body("per_page",equalTo(6))
		.body("data[0].id",equalTo(1))
		.and()
		.body("data[0].email", equalTo("george.bluth@reqres.in"))
		.and()
		.body("data[0].first_name", equalTo("George"))
		.and()
		.body("data[0].last_name", equalTo("Bluth"))
		.log().all()
		.header("Transfer-Encoding", "chunked");
//		
		
//		String Data=get(url).asString();
//		System.out.println(Data);
//		Data.charAt(0);
//		int statusCode=get(url).getStatusCode();
//		System.out.println(statusCode);	
		
	}
	//@Test
	public void postRequest() {
		
		RequestSpecification request=RestAssured.given();
		request.header("Content-Type","application/json");
		JSONObject json=new JSONObject();
		json.put("name", "TestQA");
		json.put("job", "TestLead");
		
		
		request.body(json.toJSONString());
		
		Response res=request.post("https://reqres.in/api/users");
		int statuscode=res.getStatusCode();
		System.out.println("Status code is >>>>"+statuscode);
		Assert.assertEquals(statuscode, 201);
		String data=res.asString();
		if(data.contains("TestQA")) {
			System.out.println("User is created ");
			
		}else {
			System.out.println("User is not created ");	
		}
		System.out.println("data is >>>>>"+data);
	}
	
	//@Test
	public void putRequest() {

		RequestSpecification request=RestAssured.given();
		request.header("Content-Type","application/json");
		JSONObject json=new JSONObject();
		json.put("name", "TestQA1");
		json.put("job", "Automation");
		
		
		request.body(json.toJSONString());
		
		Response res=request.put("https://reqres.in/api/users/2");
		int statuscode=res.getStatusCode();
		System.out.println("Status code is >>>>"+statuscode);
		Assert.assertEquals(statuscode, 200);
		String data=res.asString();
		if(data.contains("TestQA")) {
			System.out.println("User is created ");
			
		}else {
			System.out.println("User is not created ");	
		}
		System.out.println("data is >>>>>"+data);	
	}

	//@Test
	public void GetUserRequest() {

	GetUser getUser=RestAssured.given().expect().defaultParser(Parser.JSON)
	.when().get("https://reqres.in/api/users?page=2").as(GetUser.class);
	getUser.getPer_page();
	System.out.println(getUser.getPer_page());
	System.out.println(getUser.getPage());
	System.out.println(getUser.getTotal_pages());
	System.out.println(getUser.getSupport().getText());
	System.out.println(getUser.getSupport().getUrl());
	System.out.println(getUser.getTotal());
	
	List<Data> getData=getUser.getData();
	for(int i=0;i<getData.size();i++) {
		String firstName=getData.get(i).getFirst_name();
		String lastName=getData.get(i).getLast_name();
		String email=getData.get(i).getEmail();
		String avatar=getData.get(i).getAvatar();
		int id=getData.get(i).getId();
		
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(email);
		System.out.println(avatar);
		System.out.println(id);
		
	}
	

	}
	@Test
	public void addUser() {
		Createuser user= new Createuser();
		user.setName("Gaurav");
		user.setJob("QALead");
		RestAssured.baseURI="https://reqres.in/";
		Response res=given().body(user)
		.when().post("/api/users")
		.then().assertThat().statusCode(201).extract().response();
		String resString=res.asString();
		System.out.println(resString);
		JsonPath js = new JsonPath(resString);
		js.get("name");
		String id=js.get("id");
		//System.out.println(js.get("name"));
		System.out.println(id);
		
		
	}
}
