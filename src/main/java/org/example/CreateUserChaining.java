package org.example;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserChaining {

    @Test
    public void createUser(ITestContext context){

        Faker fakedata = new Faker();
        JSONObject data = new JSONObject();

        data.put("name",fakedata.name().fullName());
        data.put("gender","Male");
        data.put("email",fakedata.internet().emailAddress());
        data.put("status","Inactive");

        String bearerTk = "09042f73b3ab2c45dd9cd16b87ae8e85e140d0d81f5fd9d264de8d2c7d02c520";


      Response res = given()
                .headers("Authorization","Bearer "+bearerTk)
                .contentType("application/json")  //	application/json; charset=utf-8
               .body(data.toString())

                .when()
                .post("http://gorest.co.in/public/v2/users");

                int id = res.jsonPath().getInt("id");
                System.out.println("Generated Id is :"+ id );
                context.setAttribute("user_id",id);  // to make the id available for other classes(Available in test Level)
               // context.getSuite().setAttribute("user_id",id); to make the class available in Suite Level
    }
}
