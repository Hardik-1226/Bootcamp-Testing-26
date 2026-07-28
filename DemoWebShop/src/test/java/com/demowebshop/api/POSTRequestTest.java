package com.demowebshop.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Epic("API Testing")
@Feature("POST Requests")
public class POSTRequestTest extends BaseAPI {

    private static final Logger logger = LogManager.getLogger(POSTRequestTest.class);

    @Test(priority = 1)
    @Story("Login API")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify POST /auth/login returns a token")
    public void testLoginAPI() {
        logger.info("Testing POST Login");

        String requestBody = "{"
                + "\"username\": \"mor_2314\","
                + "\"password\": \"83r5^_\""
                + "}";

        given()
            .contentType("application/json")
            .body(requestBody)
        .when()
            .post("/auth/login")
        .then()
            .statusCode(200)
            .body("token", notNullValue())
            .time(lessThan(5000L));

        logger.info("POST Login - PASSED");
    }

    @Test(priority = 2)
    @Story("Create Product")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify POST /products creates a new product")
    public void testCreateProduct() {
        logger.info("Testing POST Create Product");

        String requestBody = "{"
                + "\"title\": \"Test Product from Automation\","
                + "\"price\": 49.99,"
                + "\"description\": \"Created by DemoWebShop automation framework\","
                + "\"image\": \"https://fakestoreapi.com/img/placeholder.jpg\","
                + "\"category\": \"electronics\""
                + "}";

        given()
            .contentType("application/json")
            .body(requestBody)
        .when()
            .post("/products")
        .then()
            .statusCode(200)
            .body("id", notNullValue())
            .body("title", equalTo("Test Product from Automation"))
            .body("price", equalTo(49.99f))
            .body("category", equalTo("electronics"))
            .time(lessThan(5000L));

        logger.info("POST Create Product - PASSED");
    }

    @Test(priority = 3)
    @Story("Create User")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify POST /users creates a new user")
    public void testCreateUser() {
        logger.info("Testing POST Create User");

        String requestBody = "{"
                + "\"email\": \"automation@test.com\","
                + "\"username\": \"automation_user\","
                + "\"password\": \"AutoPass@123\","
                + "\"name\": {"
                + "    \"firstname\": \"Auto\","
                + "    \"lastname\": \"Tester\""
                + "},"
                + "\"address\": {"
                + "    \"city\": \"Test City\","
                + "    \"street\": \"123 Test St\","
                + "    \"number\": 1,"
                + "    \"zipcode\": \"12345\","
                + "    \"geolocation\": {"
                + "        \"lat\": \"40.7128\","
                + "        \"long\": \"-74.0060\""
                + "    }"
                + "},"
                + "\"phone\": \"1234567890\""
                + "}";

        given()
            .contentType("application/json")
            .body(requestBody)
        .when()
            .post("/users")
        .then()
            .statusCode(200)
            .body("id", notNullValue())
            .time(lessThan(5000L));

        logger.info("POST Create User - PASSED");
    }

    @Test(priority = 4)
    @Story("Add to Cart")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify POST /carts creates a new cart with products")
    public void testAddToCart() {
        logger.info("Testing POST Add to Cart");

        String requestBody = "{"
                + "\"userId\": 5,"
                + "\"date\": \"2024-01-01\","
                + "\"products\": ["
                + "    {\"productId\": 5, \"quantity\": 1},"
                + "    {\"productId\": 1, \"quantity\": 5}"
                + "]"
                + "}";

        given()
            .contentType("application/json")
            .body(requestBody)
        .when()
            .post("/carts")
        .then()
            .statusCode(200)
            .body("id", notNullValue())
            .body("products.size()", equalTo(2))
            .time(lessThan(5000L));

        logger.info("POST Add to Cart - PASSED");
    }
}
