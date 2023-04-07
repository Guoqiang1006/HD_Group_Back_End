package com.example.project.controller;

import com.example.project.entity.Address;
import com.example.project.entity.ClientAccount;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class App_Controller {

    static HashMap<String, ClientAccount> clients = new HashMap<>();
    static HashMap<String, Address> addresses = new HashMap<>();

    public App_Controller(){
        Address address=new Address("-34.42463749447153","150.8928590557678","W125/200","Crown St","Wollongong","NSW2500",90.00,100.00);
        ClientAccount client=new ClientAccount("c1","Rick","Abc1234567","1999-05-17 00:00:00","Male","0493417283","chenguoqiangsg@gmail.com",address);

        addresses.put(address.getId(),address);
        clients.put(client.getClient_id(), client);
    }
    @GetMapping("/hello")//GetMapping示例1：浏览器输入http://localhost:8080/hello可以看到传给前端的结果。http://localhost:8080/hello?myName=Human。这个方式可以把myName的值从default转为Human。
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
