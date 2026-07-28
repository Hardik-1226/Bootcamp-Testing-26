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
@Feature("GET Requests")
public class GETRequestTest extends BaseAPI {

    private static final Logger logger = LogManager.getLogger(GETRequestTest.class);

    @Test(priority = 1)
    @Story("Get All Products")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify GET /products returns all products")
    public void testGetAllProducts() {
        logger.info("Testing GET All Products");

        given()
            .when()
                .get("/products")
            .then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("size()", greaterThan(0))
                .body("[0].id", notNullValue())
                .body("[0].title", notNullValue())
                .body("[0].price", notNullValue())
                .time(lessThan(5000L));

        logger.info("GET All Products - PASSED");
    }

    @Test(priority = 2)
    @Story("Get Single Product")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify GET /products/1 returns product with ID 1")
    public void testGetSingleProduct() {
        logger.info("Testing GET Single Product");

        given()
            .when()
                .get("/products/1")
            .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("title", notNullValue())
                .body("price", notNullValue())
                .body("description", notNullValue())
                .body("category", notNullValue())
                .body("image", notNullValue())
                .time(lessThan(5000L));

        logger.info("GET Single Product - PASSED");
    }

    @Test(priority = 3)
    @Story("Get Products by Category")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify GET /products/category/electronics returns electronics products")
    public void testGetProductsByCategory() {
        logger.info("Testing GET Products by Category");

        given()
            .when()
                .get("/products/category/electronics")
            .then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .body("category", everyItem(equalTo("electronics")))
                .time(lessThan(5000L));

        logger.info("GET Products by Category - PASSED");
    }

    @Test(priority = 4)
    @Story("Get All Categories")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify GET /products/categories returns all categories")
    public void testGetAllCategories() {
        logger.info("Testing GET All Categories");

        given()
            .when()
                .get("/products/categories")
            .then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .time(lessThan(5000L));

        logger.info("GET All Categories - PASSED");
    }

    @Test(priority = 5)
    @Story("Get All Users")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify GET /users returns all users")
    public void testGetAllUsers() {
        logger.info("Testing GET All Users");

        given()
            .when()
                .get("/users")
            .then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .body("[0].id", notNullValue())
                .body("[0].email", notNullValue())
                .body("[0].username", notNullValue())
                .time(lessThan(5000L));

        logger.info("GET All Users - PASSED");
    }

    @Test(priority = 6)
    @Story("Get Single User")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify GET /users/1 returns user with ID 1")
    public void testGetSingleUser() {
        logger.info("Testing GET Single User");

        given()
            .when()
                .get("/users/1")
            .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("email", notNullValue())
                .body("username", notNullValue())
                .body("name.firstname", notNullValue())
                .body("name.lastname", notNullValue())
                .time(lessThan(5000L));

        logger.info("GET Single User - PASSED");
    }

    @Test(priority = 7)
    @Story("Get All Carts")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify GET /carts returns all carts")
    public void testGetAllCarts() {
        logger.info("Testing GET All Carts");

        given()
            .when()
                .get("/carts")
            .then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .body("[0].id", notNullValue())
                .body("[0].userId", notNullValue())
                .body("[0].products", notNullValue())
                .time(lessThan(5000L));

        logger.info("GET All Carts - PASSED");
    }
}
