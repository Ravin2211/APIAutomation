package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class PostBodyCreation {

    //creating input by hashmap method
    //@Test
    public void Hashmapbody(){

        HashMap data = new HashMap();

        data.put("first_name","Scott");       //adding values in hashmap
        data.put("last_name","France");
        data.put("email","scott.france@ex.com");
        data.put("phone","675432");

        HashMap address = new HashMap();
        address.put("street","mayor street");
        address.put("city","losanges");
        address.put("state","LA");
        address.put("zip","908");

        data.put("address",address);
        data.put("created_at","2025-02-10T14:22:00Z");

        given()
                .contentType("application/json")
                .body(data)

                .when().post("http://localhost:3000/customers")
                .then()
                .statusCode(201)
                .body("first_name",equalTo("Scott"))
                .body("last_name",equalTo("France"))
                .body("email",equalTo("scott.france@ex.com"))
                .body("phone",equalTo("675432"))
                .body("address",equalTo(address))
//                .body("street",equalTo("mayor street"))
//                .body("city",equalTo("losanges"))
//                .body("state",equalTo("LA"))
//                .body("zip",equalTo("908"))
                .body("created_at",equalTo("2025-02-10T14:22:00Z"))
                .log().all();

    }

    //@Test
    public void deleteinput(){

        when().delete("http://localhost:3000/customers/12b8")
        .then().statusCode(200);
    }


    //Passing Body using Json object(org.json)
    //@Test
    public void JsonObjectbody(){

        JSONObject data = new JSONObject();

        data.put("first_name","Louis");
        data.put("last_name","Japan");
        data.put("email","louis.japan@ex.com");
        data.put("phone","8990890");

        HashMap address = new HashMap(); //creating hashmap for address bundle
        address.put("street","fly street");
        address.put("city","gana");
        address.put("state","GA");
        address.put("zip","890");

        data.put("address",address);
        data.put("created_at","2025-02-11T14:22:00Z");

        given()
                .contentType("application/json")
                .body(data.toString())

                .when().post("http://localhost:3000/customers")
                .then()
                .statusCode(201)
                .body("first_name",equalTo("Louis"))
                .body("last_name",equalTo("Japan"))
                .body("email",equalTo("louis.japan@ex.com"))
                .body("phone",equalTo("8990890"))
                .body("address",equalTo(address))
//                .body("address.street",equalTo("mayor street"))   //other method to check the address bundle
//                .body("address.city",equalTo("losanges"))
//                .body("address.state",equalTo("LA"))
//                .body("address.zip",equalTo("908"))
                .body("created_at",equalTo("2025-02-11T14:22:00Z"))
                .log().all();

    }

    //Passing Data or body using POJO Class- PLAIN OLD JAVA OBJECT
    //@Test
    public void BodyusingPOJOClass(){

            POJO info = new POJO();

            info.setFirst_name("Creg");
            info.setLast_name("Gen");
            info.setEmail("creg.Gen@dmail");
            info.setPhone("905465");

            //To set data for address  we use object mapper to map the data accordingly
//        ObjectMapper mapper = new ObjectMapper();
//        ObjectNode address = mapper.createObjectNode();
        HashMap<String,String> address = new HashMap<>();

        address.put("street","wilson street");
        address.put("city","texas");
        address.put("state","CA");
        address.put("zip","8976");


        info.setAddress(address);
        info.setCreated_at("2025-02-12T14:22:00Z");

            given()
                    .contentType("application/json")
                    .body(info)

                    .when().post("http://localhost:3000/customers")
                    .then()
                    .statusCode(201)
                    .body("first_name",equalTo("Creg"))
                    .body("last_name",equalTo("Gen"))
                    .body("email",equalTo("creg.Gen@dmail"))
                    .body("phone",equalTo("905465"))
                    .body("address",equalTo(address))
                    .body("created_at",equalTo("2025-02-12T14:22:00Z"))
                    .log().all();

    }

    //Passing body using external FIle
    @Test
    public void BodyusingExtFile() throws FileNotFoundException {

        File f= new File("C:\\Users\\Ravin\\APIAutomation\\src\\main\\resources\\body.json");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject data = new JSONObject(jt);

        given()
                .contentType("application/json")
                .body(data.toString())

                .when().post("http://localhost:3000/customers")

                .then()
                .statusCode(201)
                .body("first_name",equalTo("Fary"))
                .body("last_name",equalTo("Gen"))
                .body("email",equalTo("Fary.Gen@dmail"))
                .body("phone",equalTo("87554"))
                .body("address.street",equalTo("nexon street"))   //other method to check the address bundle
                .body("address.city",equalTo("texas"))
                .body("address.state",equalTo("CA"))
                .body("address.zip",equalTo("8976"))
                .body("created_at",equalTo("2025-02-01T14:22:00Z"))
                .log().all();
    }


}