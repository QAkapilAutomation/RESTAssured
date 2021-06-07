package get_Request;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ApiTest {
	
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	
	@Test
	public void Test1() {
		
		RestAssured.baseURI="https://reqres.in/";
		
		
		
		
	}

}
