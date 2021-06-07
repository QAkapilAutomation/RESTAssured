import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.User;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Createuser;
import pojo.UpdateUser;
import resources.Utility;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;

public class Practice extends Utility {
	
	public static RequestSpecification req;
	public static RequestSpecification res;
	public static ResponseSpecification resspec;
	public static Response response;
	
	
	

	//@Test
	public void GetUser() {

		RestAssured.baseURI = "https://reqres.in/";
		String Response = given().queryParam("page", 2).when().get("api/users").then().assertThat().statusCode(200)
				.body("data[0].id", equalTo(7)).extract().response().asString();
		JsonPath js = new JsonPath(Response);
		int id = js.get("data[0].id");
		int data_count = js.getInt("data.size()");
		// String email=js.get("data[1].email");
		for (int i = 0; i < data_count; i++) {
			String first_name = js.get("data[" + i + "].first_name");
			System.out.println(first_name);

			if (first_name.equalsIgnoreCase("Rachel")) {
				int id1 = js.get("data[" + i + "].id");
				System.out.println(id1);
			}
		}

		// Jira Api Code

		// TODO Auto-generated method stub

		RestAssured.baseURI = "http://localhost:8080";

		// Login Scenario

		SessionFilter session = new SessionFilter();

		String response = given().relaxedHTTPSValidation().header("Content-Type", "application/json").body("{\r\n" +

				"    \"username\": \"kapil\",\r\n" +

				"    \"password\": \"test123\"\r\n" +

				"}").log().all().filter(session).when().post("/rest/auth/1/session").then().log().all().extract()
				.response().asString();

		String expectedMessage = "Hi How are you?";

		// Add comment

		String addCommentResponse = given().pathParam("key", "10101").log().all()
				.header("Content-Type", "application/json").body("{\r\n" +

						"    \"body\": \"" + expectedMessage + "\",\r\n" +

						"    \"visibility\": {\r\n" +

						"        \"type\": \"role\",\r\n" +

						"        \"value\": \"Administrators\"\r\n" +

						"    }\r\n" +

						"}")
				.filter(session).when().post("/rest/api/2/issue/{key}/comment").then().log().all()

				.assertThat().statusCode(201).extract().response().asString();

		JsonPath js1 = new JsonPath(addCommentResponse);

		String commentId = js1.getString("id");

		// Add Attachment

		given().header("X-Atlassian-Token", "no-check").filter(session).pathParam("key", "10101")

				.header("Content-Type", "multipart/form-data")

				.multiPart("file", new File("jira.txt")).when().post("rest/api/2/issue/{key}/attachments").then().log()
				.all().assertThat().statusCode(200);

		// Get Issue

		String issueDetails = given().filter(session).pathParam("key", "10101")

				.queryParam("fields", "comment").log().all().when().get("/rest/api/2/issue/{key}").then()

				.log().all().extract().response().asString();

		System.out.println(issueDetails);

		JsonPath js2 = new JsonPath(issueDetails);
		int commentsCount = js1.getInt("fields.comment.comments.size()");

		for (int i = 0; i < commentsCount; i++)

		{

			String commentIdIssue = js2.get("fields.comment.comments[" + i + "].id").toString();

			if (commentIdIssue.equalsIgnoreCase(commentId))

			{
				String message = js1.get("fields.comment.comments[" + i + "].body").toString();

				System.out.println(message);

				Assert.assertEquals(message, expectedMessage);

			}

		}

	}

	//@Test
	public void createUser() {

		RestAssured.baseURI = "https://reqres.in/";
		String response = given().header("Content-Type", "text/plain").body(Payload.createuser1("Gaurav", "QALead"))
				.when().post("api/users").then().assertThat().statusCode(201).extract().response().asString();
		System.out.println(response);

		JsonPath js = new JsonPath(response);
		String name = js.get("id").toString();
		System.out.println(name);
	}

	// @Test
	public void oAuth() {

		String url = "https://rahulshettyacademy.com/getCourse.php?state=verifyfjdss&code=4%2FvAHBQUZU6o4WJ719NrGBzSELBFVBI9XbxvOtYpmYpeV47bFVExkaxWaF_XR14PHtTZf7ILSEeamywJKwo_BYs9M&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&session_state=0c32992f0d47e93d273922018ade42d1072b9d1f..a35c&prompt=none#";

		String partialcode = url.split("code=")[1];

		String code = partialcode.split("&scope")[0];

		System.out.println(code);

		String response =

				given()

						.urlEncodingEnabled(false)

						.queryParams("code", code)

						.queryParams("client_id",
								"692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")

						.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")

						.queryParams("grant_type", "authorization_code")

						.queryParams("state", "verifyfjdss")

						.queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")

						// .queryParam("scope",
						// "email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email")

						.queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")

						.when().log().all()

						.post("https://www.googleapis.com/oauth2/v4/token").asString();

		// System.out.println(response);

		JsonPath jsonPath = new JsonPath(response);

		String accessToken = jsonPath.getString("access_token");

		System.out.println(accessToken);

		String r2 = given().contentType("application/json").

				queryParams("access_token", accessToken).expect().defaultParser(Parser.JSON)

				.when()

				.get("https://rahulshettyacademy.com/getCourse.php")

				.asString();

		System.out.println(r2);

	}

	@Test
	public void test3 () throws IOException {

		req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).setContentType(ContentType.JSON).build();

		res = given().spec(req).queryParam("page", 2);
		
		resspec= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		response = res.when().get("api/users").then().spec(resspec).extract().response();

		String responseString = response.asString();
		System.out.println(responseString);
		//String[] responseString1= responseString.split(":");
		
		//for (String a : responseString1)
          //  System.out.println(a);
		

		JsonPath jspath = new JsonPath(responseString);
		int id = jspath.get("data[0].id");
		System.out.println(id);
		int data_count = jspath.getInt("data.size()");
		// String email=js.get("data[1].email");
		for (int i = 0; i < data_count; i++) {
			String first_name = jspath.get("data[" + i + "].first_name");
			System.out.println(first_name);

			if (first_name.equalsIgnoreCase("Lindsay")) {
				int id1 = jspath.get("data[" + i + "].id");
				System.out.println(id1);
				break;
			}

		}

	}
	@Test
	public void putrequest() throws IOException {
		
		Createuser user= new Createuser();
		user.setJob("manager");
		user.setName("Gaurav");
		
		req= new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).setContentType(ContentType.JSON).build();
		
		//res=given().spec(req).queryParam("page", "2").body(Payload.createuser1("Gaurav", "manager"));
		
		res=given().spec(req).queryParam("page", "2").body(user);
		
		resspec= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		response  =res.when().put("api/users").then().spec(resspec).extract().response();
		
		String responseString =response.asString();
		
		System.out.println(responseString);
		
		JsonPath jspath= new JsonPath(responseString);
		String name =jspath.get("name");
		String job=jspath.get("job");
		String upadteOn=jspath.get("updatedAt");
		
		System.out.println(name);
		System.out.println(job);
		System.out.println(upadteOn);
		
	}
	
	@Test
	public void updateUser() throws Exception {
		
		UpdateUser user= new UpdateUser();
		user.setJob("QA");
		user.setName("Mohan");
		
		req=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).setContentType(ContentType.JSON).build();
		
		res=given().spec(req).queryParam("page", "2").body(user);
		
		resspec= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		UpdateUser user1= res.when().put("api/users").then().spec(resspec).extract().as(UpdateUser.class);
		
		String name=user1.getName();
		String job =user1.getJob();
		String updateAt=user1.getUpdatedAt();
		System.out.println(name);
		System.out.println(job);
		System.out.println(updateAt);
		
		
	}
	
}
