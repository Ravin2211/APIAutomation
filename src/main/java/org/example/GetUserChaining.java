package org.example;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUserChaining {

    @Test
    public void getUser(ITestContext context){   //To enable the id to use everywhere

        int id = (int) context.getAttribute("user_id");

        String bearerTK = "09042f73b3ab2c45dd9cd16b87ae8e85e140d0d81f5fd9d264de8d2c7d02c520";

        given()
                .headers("Authorization","Bearer "+bearerTK)
                .contentType("application/json")
                .pathParam("id",id)

                .when()
                .get("http://gorest.co.in/public/v2/users/{id}")

                .then()
                .statusCode(200)
                .log().all();
    }
}
