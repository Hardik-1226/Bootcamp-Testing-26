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
 * DELETERequestTest - Tests for all DELETE API endpoints.
 * Deletes products, users, and carts.
 */
@Epic("API Testing")
@Feature("DELETE Requests")
public class DELETERequestTest extends BaseAPI {

    private static final Logger logger = LogManager.getLogger(DELETERequestTest.class);

    @Test(priority = 1)
    @Story("Delete Product")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify DELETE /products/6 deletes a product")
    public void testDeleteProduct() {
        logger.info("Testing DELETE Product");

        given()
        .when()
            .delete("/products/6")
        .then()
            .statusCode(200)
            .body("id", notNullValue())
            .time(lessThan(5000L));

        logger.info("DELETE Product - PASSED");
    }

    @Test(priority = 2)
    @Story("Delete User")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify DELETE /users/6 deletes a user")
    public void testDeleteUser() {
        logger.info("Testing DELETE User");

        given()
        .when()
            .delete("/users/6")
        .then()
            .statusCode(200)
            .body("id", notNullValue())
            .time(lessThan(5000L));

        logger.info("DELETE User - PASSED");
    }

    @Test(priority = 3)
    @Story("Delete Cart")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify DELETE /carts/6 deletes a cart")
    public void testDeleteCart() {
        logger.info("Testing DELETE Cart");

        given()
        .when()
            .delete("/carts/6")
        .then()
            .statusCode(200)
            .body("id", notNullValue())
            .time(lessThan(5000L));

        logger.info("DELETE Cart - PASSED");
    }
}
