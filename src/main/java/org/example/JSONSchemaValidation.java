package org.example;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JSONSchemaValidation {



    @Test
    public void jsonschematest(){


        given()

                .when().get("http://localhost:3000/stores")

                .then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storesJSONSchema.json"));
    }
}

// XML SCHEMA VALIDATION CODE

//Cannot do xml schema validation as the xml body is not available

//given()
//
//                .when().get("no api available")
//
//                .then()
//                .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("name.xsd(doesnot exists"));
//    }
