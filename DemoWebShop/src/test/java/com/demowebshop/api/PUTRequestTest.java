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

/**
 * PUTRequestTest - Tests for all PUT API endpoints.
 * Updates existing products, users, and carts.
 */
@Epic("API Testing")
@Feature("PUT Requests")
public class PUTRequestTest extends BaseAPI {

    private static final Logger logger = LogManager.getLogger(PUTRequestTest.class);

    @Test(priority = 1)
    @Story("Update Product")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify PUT /products/7 updates an existing product")
    public void testUpdateProduct() {
        logger.info("Testing PUT Update Product");

        // Request body with updated product data
        String requestBody = "{"
                + "\"title\": \"Updated Product by Automation\","
                + "\"price\": 99.99,"
                + "\"description\": \"Updated description\","
                + "\"image\": \"https://fakestoreapi.com/img/placeholder.jpg\","
                + "\"category\": \"electronics\""
                + "}";

        given()
            .contentType("application/json")
            .body(requestBody)
        .when()
            .put("/products/7")
        .then()
            .statusCode(200)
            .body("title", equalTo("Updated Product by Automation"))
            .body("price", equalTo(99.99f))
            .body("category", equalTo("electronics"))
            .time(lessThan(5000L));

        logger.info("PUT Update Product - PASSED");
    }

    @Test(priority = 2)
    @Story("Update User")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify PUT /users/7 updates an existing user")
    public void testUpdateUser() {
        logger.info("Testing PUT Update User");

        // Request body with updated user data
        String requestBody = "{"
                + "\"email\": \"updated@automation.com\","
                + "\"username\": \"updated_automation\","
                + "\"password\": \"NewPass@789\","
                + "\"name\": {"
                + "    \"firstname\": \"Updated\","
                + "    \"lastname\": \"Tester\""
                + "},"
                + "\"address\": {"
                + "    \"city\": \"Updated City\","
                + "    \"street\": \"456 Update St\","
                + "    \"number\": 2,"
                + "    \"zipcode\": \"67890\","
                + "    \"geolocation\": {"
                + "        \"lat\": \"51.5074\","
                + "        \"long\": \"-0.1278\""
                + "    }"
                + "},"
                + "\"phone\": \"9876543210\""
                + "}";

        given()
            .contentType("application/json")
            .body(requestBody)
        .when()
            .put("/users/7")
        .then()
            .statusCode(200)
            .body("id", notNullValue())
            .time(lessThan(5000L));

        logger.info("PUT Update User - PASSED");
    }

    @Test(priority = 3)
    @Story("Update Cart")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify PUT /carts/7 updates an existing cart")
    public void testUpdateCart() {
        logger.info("Testing PUT Update Cart");

        // Request body with updated cart data
        String requestBody = "{"
                + "\"userId\": 3,"
                + "\"date\": \"2024-06-15\","
                + "\"products\": ["
                + "    {\"productId\": 1, \"quantity\": 3},"
                + "    {\"productId\": 2, \"quantity\": 1},"
                + "    {\"productId\": 3, \"quantity\": 2}"
                + "]"
                + "}";

        given()
            .contentType("application/json")
            .body(requestBody)
        .when()
            .put("/carts/7")
        .then()
            .statusCode(200)
            .body("id", notNullValue())
            .body("products.size()", equalTo(3))
            .time(lessThan(5000L));

        logger.info("PUT Update Cart - PASSED");
    }
}
