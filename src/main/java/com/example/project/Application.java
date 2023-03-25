package com.example.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        app_controller controller=new app_controller();
        SpringApplication.run(Application.class, args);
    }


}
