package com.example.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@SpringBootApplication
@RestController
public class Application {
    private static HashMap<Integer,Client_account> clients = new HashMap<>();

    public static void main(String[] args) {
        Address address=new Address("-34.42463749447153","150.8928590557678","W125/200","Crown St","Wollongong","NSW2500",90.00,100.00);
        Client_account client=new Client_account("Rick","Abc1234567","1999-05-17 00:00:00","Male","0493417283","chenguoqiangsg@gmail.com",address);
        clients.put(client.getClient_id(), client);
        System.out.println(client.getClient_id());
        SpringApplication.run(Application.class, args);
    }
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/account")
    public String getClient(@RequestParam(value = "account_id") int id) {
        return clients.get(id).toString();
    }

}
