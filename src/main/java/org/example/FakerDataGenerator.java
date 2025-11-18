package org.example;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerDataGenerator {


    //To genearte random fake datas for test
    @Test
    public void fakerfunc(){

        Faker fake = new Faker();


        String Fullname = fake.name().fullName();
        String FirstName = fake.name().firstName();
        String LastName = fake.name().lastName();
        String UserName = fake.name().username();
        String Password = fake.internet().password();
        String Phone = fake.phoneNumber().cellPhone();
        String Email = fake.internet().emailAddress();

        System.out.println("Fullname"+ Fullname);
        System.out.println("FirstName"+ FirstName);
        System.out.println("LastName"+ LastName);
        System.out.println("UserNAme"+ UserName);
        System.out.println("Password"+ Password);
        System.out.println("Phone "+Phone);
        System.out.println("Email "+Email);

    }
}
