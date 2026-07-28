package com.RestAssuredPost;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class POST {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private JSONObject testUser;
    private int createdUserId;

    @BeforeClass
    public void setup() {

        RestAssured.baseURI = BASE_URL;

        // Common test data
        testUser = new JSONObject();
        testUser.put("name", "Test User");
        testUser.put("email", "brahmdang@gmail.com");
        testUser.put("username", "brahm");
    }

    @Test(priority = 1)
    public void testPostRequestComplete() {

        System.out.println("\n========== POST REQUEST ==========");

        JSONObject user = new JSONObject(testUser.toString());
        user.put("id", 1);

        System.out.println("Request Body:");
        System.out.println(user.toString(2));

        Response response = given()
                .header("Content-Type", "application/json")
                .body(user.toString())
        .when()
                .post("/users")
        .then()
                .extract()
                .response();

        printResponseDetails(response, "POST");

        Assert.assertEquals(response.getStatusCode(), 201);

        JSONObject responseJson = new JSONObject(response.getBody().asString());

        if (responseJson.has("id")) {
            createdUserId = responseJson.getInt("id");
            System.out.println("Created User ID: " + createdUserId);
        }
    }

    private void printResponseDetails(Response response, String requestType) {

        System.out.println("\n========== " + requestType + " RESPONSE ==========");
        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Status Line : " + response.getStatusLine());
        System.out.println("Response Time : " + response.getTime() + " ms");
        System.out.println("Response Body:");
        System.out.println(response.getBody().asPrettyString());
    }
}