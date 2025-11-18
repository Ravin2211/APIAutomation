package org.example;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class parsingResponse {

    @Test
    public void testparsing(){


        // Method 1----within body(cant be used repetitively)
//        given()
//                .contentType(ContentType.JSON)
//                .when()
//                .get("http://localhost:3000/stores")
//                .then()
//                .statusCode(200)
//                .header("Content-Type", containsString("application/json"))
//                .body("[0].address", equalTo("Mat Street"));

        //Method 2--- Response interface(can be used to access diff validations)

//       Response res = given()
//               .contentType(ContentType.JSON)
//
//                .when().get("http://localhost:3000/stores");
//
//        Assert.assertEquals(res.getStatusCode(),200);
//        Assert.assertEquals(res.header("Content-Type"),"application/json");
//
//        String Address = res.jsonPath().get("[0].address").toString();
//        Assert.assertEquals(Address,"Mat Street");

        //Method 3---Json Object Class- can get the values even when they are not in ordered form(Most Prefered method)

        Response res = given()
                .contentType(ContentType.JSON)

                .when().get("http://localhost:3000/stores");

        JSONArray jo = new JSONArray(res.asString());    //Convert the output from response type to object

        boolean status = false;

        //search the given title
        for(int i =0; i<jo.length();i++){
            String storeName = jo.getJSONObject(i).get("storeName").toString();
            System.out.println(storeName);

            if(storeName.equals("sam Grocery")){
                    status= true;
                 System.out.println("The store is found");
                 break;
            }
        }
        Assert.assertEquals(status,true);

        //validate total price of store
        double totalprice =0;

        for( int i=0;i<jo.length();i++){
            String price = jo.getJSONObject(i).get("price").toString();
            totalprice=totalprice+Double.parseDouble(price);

        }
        System.out.println(totalprice);

        Assert.assertEquals(totalprice,1600.0);

    }
}
