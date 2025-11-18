package org.example;

// POJO-----Serialize-->JSONObject---DeSerialize--->POJO

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class SerialDeSerialization {

    //@Test
    public void Serialization() throws JsonProcessingException {


        //Creating JAva Object sp
        StudentPOJO sp = new StudentPOJO();
        sp.setFirst_name("lizy");
        sp.setLast_name("ferick");
        sp.setEmail("lizy.ferick@den.com");
        sp.setPhone("6789");
        sp.setCreated_at("2025-02-10T14:22:00Z");
        //convert java object to json object
        ObjectMapper objmap = new ObjectMapper();
        String Jsondata = objmap.writerWithDefaultPrettyPrinter().writeValueAsString(sp);
        System.out.println(Jsondata);

    }

    @Test
    public void DeSerialization() throws JsonProcessingException {

        String Jsonfile = "{\n" +
                "  \"first_name\" : \"lizy\",\n" +
                "  \"last_name\" : \"ferick\",\n" +
                "  \"email\" : \"lizy.ferick@den.com\",\n" +
                "  \"phone\" : \"6789\",\n" +
                "  \"created_at\" : \"2025-02-10T14:22:00Z\"\n" +
                "}";
        //convert json data to java object
        ObjectMapper deobj = new ObjectMapper();    //use only jacksonbinder
        //convert json to pojo class
        StudentPOJO classconvert = deobj.readValue(Jsonfile, StudentPOJO.class);
        System.out.println(classconvert.getFirst_name());
        System.out.println(classconvert.getLast_name());
        System.out.println(classconvert.getEmail());
        System.out.println(classconvert.getPhone());
        System.out.println(classconvert.getCreated_at());
   }
}
