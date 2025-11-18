package org.example;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Authentication {

    @Test(priority = 1)
    public void BasicAuth(){

        given()
                .auth().basic("postman","password")

                .when()
                .get("https://postman-echo.com/basic-auth")

                .then()
                .statusCode(200);
    }

    @Test(priority = 2)
    public void DigestAuth(){

        given()
                .auth().digest("postman","password")

                .when()
                .get("https://postman-echo.com/basic-auth")

                .then()
                .statusCode(200);
    }

    @Test(priority = 3)
    public void Preemptive(){

        given()
                .auth().preemptive().basic("postman","password")

                .when()
                .get("https://postman-echo.com/basic-auth")

                .then()
                .statusCode(200);
    }

    @Test(priority = 4)
    public void BearerToken(){

        String bearertoken ="" ;

        given()
                .headers("Authorization","Bearer"+bearertoken)

                .when()
                .get("any url with bearer token")

                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 5)
    public void Outhone(){

        given()
                .auth().oauth("consumerKey","consumerSecret","accessToken","tokenSecret")

                .when()
                .get("any url with oauth1")

                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 6)
    public void OuthTwo(){

        given()
                .auth().oauth2("give ouath2 token")

                .when()
                .get("any url with oauth2")

                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 7)
    public void APIKey(){

        //use the given website and create the token after logging in through mailid
        given()
                .queryParam("AuthAPIKey","6b6a4b448aca659726f91ea9d48338c0")

                .when()
                .get("https://home.openweathermap.org/api_keys")

                .then()
                .statusCode(200)
                .log().all();
    }

}
