package com.example.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CompleteAPITest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.basePath = "";
    }

    @Test(priority = 1)
    public void testTraditionalApproach() {

        System.out.println("\n\n========== TRADITIONAL APPROACH ==========");

        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "Traditional Post");
        requestBody.put("body", "Testing traditional approach");
        requestBody.put("userId", 1);

        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());

        Response response = request.post("/posts");

        printResponseDetails(response, "Traditional");
    }

    
    @Test(priority = 2)
    public void testBDDApproach() {

        System.out.println("\n\n========== BDD APPROACH ==========");

        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "BDD Post");
        requestBody.put("body", "Testing BDD approach");
        requestBody.put("userId", 2);

        // BDD Style
        given()
            .header("Content-Type", "application/json")
            .body(requestBody.toString())
        .when()
            .post("/posts")
        .then()
            .statusCode(201)
            .statusLine(containsString("201"))
            .contentType("application/json")
            .body("title", equalTo("BDD Post"))
            .body("userId", equalTo(2))
            .time(lessThan(5000L))
            .log().all();
    }
    
    @Test(priority = 3)
    public void testBDDApproachWithExtraction() {

        System.out.println("\n\n========== BDD APPROACH WITH EXTRACTION ==========");

        // Create JSON object
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "BDD with Extraction");
        requestBody.put("body", "Testing BDD with response extraction");
        requestBody.put("userId", 3);

        // BDD with extraction
        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
            .when()
                .post("/posts")
            .then()
                .statusCode(201)
                .extract()
                .response();

        // Print response details
        printResponseDetails(response, "BDD Extraction");
    }

    // Helper method to print response details
    private void printResponseDetails(Response response, String approach) {

        System.out.println("\n--- " + approach + " Approach Response Details ---");
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Status Line: " + response.getStatusLine());
        System.out.println("Content Type: " + response.getContentType());
        System.out.println("Response Time: " + response.getTime() + " ms");
        System.out.println("Response Body: " + response.getBody().asString());
        System.out.println("Complete Response: " + response.asString());
    }
}
