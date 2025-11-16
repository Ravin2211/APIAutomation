package org.example;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class CookiesHandle {

    //@Test(priority =1)
    public void testCookies(){

        given()
                .when().get("https://www.google.com/")
                .then()
                .cookie("AEC","AaJma5v5O6xUMm7gpCVES-KxJkbO07cdrTRBLL6LgDaGI6SL7Ai_zxoxUA")
                .log().all();
    }

    @Test(priority =2)
    public void getCookiesInfo(){

        Response res=given()
                .when().get("https://www.google.com/");

        //to get the value of the cookie
        String AECvalue= res.getCookie("AEC");
        System.out.println("The Value of AEC cookie is: "+AECvalue);

        //get all cookies info
        Map<String,String> cookies_values =res.getCookies();
        System.out.println(cookies_values.keySet());


        //get all cookies with their values
        for(String k:cookies_values.keySet()){
            String value=res.getCookie(k);
            System.out.println(k+"  "+value);
        }
    }
}
