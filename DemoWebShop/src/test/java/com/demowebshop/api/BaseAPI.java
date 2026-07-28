package com.demowebshop.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

/**
 * BaseAPI - Base class for all REST Assured API tests.
 * Sets up the base URI and provides a reusable request spec.
 */
public class BaseAPI {

    private static final Logger logger = LogManager.getLogger(BaseAPI.class);

    // Base URL for FakeStoreAPI
    protected static final String BASE_URL = "https://fakestoreapi.com";

    /**
     * Setup method - runs before each test class.
     * Sets the base URI for all API requests.
     */
    @BeforeClass
    public void setupAPI() {
        RestAssured.baseURI = BASE_URL;
        logger.info("REST Assured Base URI set to: {}", BASE_URL);
    }

    /**
     * Returns a basic request spec with JSON content type.
     * Use this in your tests to avoid repeating headers.
     *
     * @return RequestSpecification with content type set to JSON
     */
    protected RequestSpecification getRequestSpec() {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);
    }

    /**
     * Returns a request spec with auth token.
     * Use this for authenticated API calls.
     *
     * @param token JWT token
     * @return RequestSpecification with auth header
     */
    protected RequestSpecification getAuthRequestSpec(String token) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + token);
    }
}
