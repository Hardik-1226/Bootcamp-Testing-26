package com.demowebshop.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

public class BaseAPI {

    private static final Logger logger = LogManager.getLogger(BaseAPI.class);

    protected static final String BASE_URL = "https://fakestoreapi.com";

    @BeforeClass
    public void setupAPI() {
        RestAssured.baseURI = BASE_URL;
        logger.info("REST Assured Base URI set to: {}", BASE_URL);
    }

    protected RequestSpecification getRequestSpec() {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);
    }

    protected RequestSpecification getAuthRequestSpec(String token) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + token);
    }
}
