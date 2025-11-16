package org.example;

import java.util.HashMap;

public class POJO {

    String first_name;
    String last_name;
    String email;
    String phone;
    HashMap<String,String> address;
    String created_at;




    //Get method for first name
    public String getFirst_name() {
        return first_name;
    }
    //Set method for first name
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    //Get method for last name
    public String getLast_name() {
        return last_name;
    }
    //Set method for Last name
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    //Get method for Email
    public String getEmail() {
        return email;
    }
    //Set method for Email
    public void setEmail(String email) {
        this.email = email;
    }
    //Get method for Phone
    public String getPhone() {
        return phone;
    }
    //Set method for Phone
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public HashMap<String, String> getAddress() {
        return address;
    }

    public void setAddress(HashMap<String,String> address) {
        this.address =address;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

}
