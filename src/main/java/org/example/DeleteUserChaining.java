package org.example;

import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

public class DeleteUserChaining {

    @Test
    public void testdelete(ITestContext context) {

        String bearerTk = "09042f73b3ab2c45dd9cd16b87ae8e85e140d0d81f5fd9d264de8d2c7d02c520";
        int id = (int) context.getAttribute("user_id");

        given()
                .headers("Authorization", "Bearer " + bearerTk)
                .contentType("application/json")
                .pathParam("id", id)

                .when()
                .delete("http://gorest.co.in/public/v2/users/{id}")

                .then()
                .statusCode(200)
                .log().all();
    }

}
