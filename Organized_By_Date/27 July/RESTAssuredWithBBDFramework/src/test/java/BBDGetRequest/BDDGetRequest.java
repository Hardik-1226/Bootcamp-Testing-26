package BBDGetRequest;
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class BDDGetRequest {

    @Test
    public void getRequest() {

        Response response = given()
                                .baseUri("https://fakestoreapi.com")

                            .when()
                                .get("/products/1")

                            .then()
                                .statusCode(200)
                                .extract()
                                .response();

        // Print complete response body
        System.out.println(response.asPrettyString());

        // Print status code
        System.out.println("Status Code: " + response.getStatusCode());

        // Print status line
        System.out.println("Status Line: " + response.getStatusLine());

        // Print response time
        System.out.println("Response Time: " + response.getTime() + " ms");

        // Print headers
        System.out.println("Headers: " + response.getHeaders());

        // Print specific values from JSON
        System.out.println("Product ID: " + response.jsonPath().getInt("id"));
        System.out.println("Title: " + response.jsonPath().getString("title"));
        System.out.println("Price: " + response.jsonPath().getFloat("price"));
        System.out.println("Category: " + response.jsonPath().getString("category"));
    }
}