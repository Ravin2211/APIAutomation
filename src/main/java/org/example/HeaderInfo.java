package org.example;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class HeaderInfo {

    //@Test(priority=1)
    public void testHeader(){

        //Content-Type,Content-Encoding,Server are some stable values
        given()
                .when().get("https://www.google.com/")

                .then()
                .header("Content-Type","text/html; charset=ISO-8859-1")
                .header("Content-Encoding","gzip")
                .header("Server","gws")
                .log().all();    // instead use log().headers() -- to get only headers in output
    }

    @Test(priority=2)
    public void getHeaderContent(){

        //Content-Type,Content-Encoding,Server are some stable values
        Response res =given()
                .when().get("https://www.google.com/");

        //get single header info
       String Headervalue = res.getHeader("Content-Type");
       System.out.println(Headervalue);

       //get all header info
        Headers allheaders = res.getHeaders();
        for(Header hd:allheaders){
            System.out.println(hd.getName()+"  "+hd.getValue());
        }

    }
}
