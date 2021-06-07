package files;

public class Payload {
	
	public static String ceateUser() {
		
		return "{\r\n" + 
				"  \"XACTDOC\": {\r\n" + 
				"    \"XACTNET_INFO\": {\r\n" + 
				"      \"carrierId\": \"2410045\",\r\n" + 
				"      \"recipientsXNAddress\": \"CRAWFORD.HOME.WEB\"\r\n" + 
				"    },\r\n" + 
				"    \"CONTACTS\": {\r\n" + 
				"      \"CONTACT\": {\r\n" + 
				"        \"type\": \"Client\",\r\n" + 
				"        \"name\": \"Olie Stone\",\r\n" + 
				"        \"MORTGAGES\": {\r\n" + 
				"          \"MORTGAGE\": {\r\n" + 
				"            \"mortgagee\": \"DA BANK\",\r\n" + 
				"            \"loanNum\": \"123456\"\r\n" + 
				"          }\r\n" + 
				"        },\r\n" + 
				"        \"ADDRESSES\": {\r\n" + 
				"          \"ADDRESS\": [\r\n" + 
				"            {\r\n" + 
				"              \"type\": \"Property\",\r\n" + 
				"              \"country\": \"US\",\r\n" + 
				"              \"city\": \"Provo\",\r\n" + 
				"              \"street\": \"665 S 300 E\",\r\n" + 
				"              \"state\": \"UT\",\r\n" + 
				"              \"postal\": \"84601\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"type\": \"Home\",\r\n" + 
				"              \"country\": \"US\",\r\n" + 
				"              \"city\": \"Provo\",\r\n" + 
				"              \"street\": \"189 S 300 E\",\r\n" + 
				"              \"state\": \"UT\",\r\n" + 
				"              \"postal\": \"84604\"\r\n" + 
				"            }\r\n" + 
				"          ]\r\n" + 
				"        },\r\n" + 
				"        \"CONTACTMETHODS\": {\r\n" + 
				"          \"PHONE\": [\r\n" + 
				"            {\r\n" + 
				"              \"type\": \"Home\",\r\n" + 
				"              \"number\": \"801-226-2252\",\r\n" + 
				"              \"extension\": \"123\",\r\n" + 
				"              \"primary\": \"1\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"type\": \"Business\",\r\n" + 
				"              \"number\": \"801-226-2253\",\r\n" + 
				"              \"extension\": \"145\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"type\": \"Cell\",\r\n" + 
				"              \"number\": \"801-226-2254\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"type\": \"Other\",\r\n" + 
				"              \"number\": \"801-226-2255\",\r\n" + 
				"              \"extension\": \"154\"\r\n" + 
				"            }\r\n" + 
				"          ],\r\n" + 
				"          \"EMAIL\": {\"address\": \"test321@mailinator.com\"}\r\n" + 
				"        }\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    \"PROJECT_INFO\": {\"NOTES\": \"test notes from claim DD20003\"},\r\n" + 
				"    \"ADM\": {\r\n" + 
				"      \"dateReceived\": \"2013-03-25\",\r\n" + 
				"      \"dateOfLoss\": \"2012-03-01\",\r\n" + 
				"      \"COVERAGE_LOSS\": {\r\n" + 
				"        \"policyNumber\": \"PNDD20010\",\r\n" + 
				"        \"catastrophe\": \"805\",\r\n" + 
				"        \"claimNumber\": \"DD20012\",\r\n" + 
				"        \"policyStart\": \"2020-01-01\",\r\n" + 
				"        \"policyEnd\": \"2021-01-01\",\r\n" + 
				"        \"dateInitCov\": \"2012-01-01\",\r\n" + 
				"        \"isCommercial\": \"0\",\r\n" + 
				"        \"COVERAGES\": {\r\n" + 
				"          \"COVERAGE\": [\r\n" + 
				"            {\r\n" + 
				"              \"id\": \"COV1\",\r\n" + 
				"              \"covType\": \"0\",\r\n" + 
				"              \"covName\": \"Dwelling\",\r\n" + 
				"              \"deductible\": \"500\",\r\n" + 
				"              \"policyLimit\": \"1000000\",\r\n" + 
				"              \"reserveAmt\": \"1000.00\",\r\n" + 
				"              \"applyTo\": \"1\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"id\": \"COV2\",\r\n" + 
				"              \"covType\": \"1\",\r\n" + 
				"              \"covName\": \"Structural\",\r\n" + 
				"              \"deductible\": \"500\",\r\n" + 
				"              \"policyLimit\": \"1000000\",\r\n" + 
				"              \"reserveAmt\": \"1000.00\",\r\n" + 
				"              \"applyTo\": \"2\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"id\": \"COV3\",\r\n" + 
				"              \"covType\": \"2\",\r\n" + 
				"              \"covName\": \"Contents\",\r\n" + 
				"              \"deductible\": \"500\",\r\n" + 
				"              \"policyLimit\": \"100000\",\r\n" + 
				"              \"reserveAmt\": \"1000.00\",\r\n" + 
				"              \"applyTo\": \"1\"\r\n" + 
				"            }\r\n" + 
				"          ]\r\n" + 
				"        },\r\n" + 
				"        \"TOL\": {\r\n" + 
				"          \"desc\": \"Water\",\r\n" + 
				"          \"code\": \"WATER\",\r\n" + 
				"          \"COL\": {\r\n" + 
				"            \"desc\": \"Broken Pipe\",\r\n" + 
				"            \"otherCause\": \"High Water Pressure\"\r\n" + 
				"          }\r\n" + 
				"        },\r\n" + 
				"        \"FORMS\": {\r\n" + 
				"          \"FORM\": [\r\n" + 
				"            {\r\n" + 
				"              \"name\": \"BP0009\",\r\n" + 
				"              \"editionDate\": \"01-1997\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"name\": \"BP0008\",\r\n" + 
				"              \"editionDate\": \"01-1998\"\r\n" + 
				"            }\r\n" + 
				"          ]\r\n" + 
				"        }\r\n" + 
				"      }\r\n" + 
				"    }\r\n" + 
				"  }\r\n" + 
				"}";
	}
	
	public static String createuser1(String name,String Job) {
		
		String payload="{\r\n" + 
				"    \"name\": \""+name+"\",\r\n" + 
				"    \"job\": \""+Job+"\"\r\n" + 
				"}";
		return payload;
				
		
	}

}
