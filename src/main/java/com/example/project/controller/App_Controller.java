package com.example.project.controller;

import com.example.project.entity.*;
import com.example.project.load_data;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

@RestController
public class App_Controller {

    public static HashMap<String, ClientAccount> clients = new HashMap<>();
    public static HashMap<String, ProviderAccount> providers = new HashMap<>();
    public static HashMap<String, Address> addresses = new HashMap<>();
    public static HashMap<String, Voucher> vouchers = new HashMap<>();
    public static HashMap<String, Wallet> wallets = new HashMap<>();
    public static HashMap<String, Payment> payments = new HashMap<>();
    public static HashMap<String, Membership> memberships = new HashMap<>();

    public static HashMap<String, Order> orders = new HashMap<>();

    public App_Controller() throws ParseException, IOException {
        load_data data=new load_data();
    }
    @GetMapping("/hello")//GetMapping示例1：浏览器输入http://localhost:8080/hello可以看到传给前端的结果。http://localhost:8080/hello?myName=Human。这个方式可以把myName的值从default转为Human。
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
