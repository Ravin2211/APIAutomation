package org.example;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class parsingResponse {

    @Test
    public void testparsing(){


        // Method 1
//        given()
//                .contentType(ContentType.JSON)
//                .when()
//                .get("http://localhost:3000/stores")
//                .then()
//                .statusCode(200)
//                .header("Content-Type", containsString("application/json"))
//                .body("[0].address", equalTo("Mat Street"));

        //Method 2

       Response res = given()
               .contentType("ContentType.JSON")

                .when().get("http://localhost:3000/stores");

        Assert.assertEquals(res.getStatusCode(),200);
        Assert.assertEquals(res.header("Content-Type"),"application/json");

        String Address = res.jsonPath().get("[0].address").toString();
        Assert.assertEquals(Address,"Mat Street");


    }
}
