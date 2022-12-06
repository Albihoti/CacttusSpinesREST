package com.example.springbootproject;

import com.example.springbootproject.model.Perdoruesi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProjectApplication {

    public static void main(String[] args) {
        Perdoruesi neeUser = new Perdoruesi();


        SpringApplication.run(SpringBootProjectApplication.class, args);
    }

}
