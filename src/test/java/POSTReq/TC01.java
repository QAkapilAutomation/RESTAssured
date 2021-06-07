package POSTReq;

import org.testng.annotations.Test;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import pojo.ClaimResponse;
import pojo.Getclaims;
import resources.Utility;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.util.List;

public class TC01 extends Utility {

	@Test
	public void CreateUser() throws Exception {

		RestAssured.baseURI = getGlobalValue("baseUrl");
		Getclaims claims = given().auth().oauth2(getGlobalValue("accessToken")).relaxedHTTPSValidation().expect()
							.defaultParser(Parser.JSON)
							.when().get("/api/claims").as(Getclaims.class);
		int allclaims = claims.getAllClaim();
		int myQueue = claims.getMyQueue();
		System.out.println("all claims no=" + allclaims + "claims in  myQueue=" + myQueue);

		List<ClaimResponse> claimResponse = claims.getClaimResponse();

		for (int i = 0; i < claimResponse.size(); i++) {
			// System.out.println(claimResponse.get(i).getClaimNo());
			if (claimResponse.get(i).getClaimNo().equalsIgnoreCase("KG-100899083")) {
				System.out.println(claimResponse.get(i).getAddress1());
			}
		}

	}
}
