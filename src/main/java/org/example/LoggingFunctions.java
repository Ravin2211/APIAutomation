package org.example;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoggingFunctions {

    @Test
    public void testlogs(){

        given()

                .when().get("https://reqres.in/api-docs/")

                .then()
                //.log().all()     // this will print all  in console window
                //.log().body();     // this prints only the html response
                //.log().cookies();   //this will print only cookies
                .log().headers();       //this will print only headers in console
    }
}
