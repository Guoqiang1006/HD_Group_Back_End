package com.example.project.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;

import static com.example.project.controller.App_Controller.vouchers;

@JsonPropertyOrder({"user_id", "vouchers_owned", "balance" })//初始化json排列方法
@JsonInclude(JsonInclude.Include.ALWAYS)//初始化内容为空时json传递null
public class Wallet {
    private String user_id;
    private HashMap<String,Voucher> vouchers_owned = new HashMap<String,Voucher>();
    private double balance;
    public Wallet(String user_id,String voucher_id, double balance) {
        this.user_id = user_id;
        String[] vs=voucher_id.split(",");
        for(String v:vs){
            vouchers_owned.put(v,vouchers.get(v));
        }
        this.balance = balance;
    }

    public String getUser_id() {
        return user_id;
    }

    public HashMap<String, Voucher> getVouchers_owned() {
        return vouchers_owned;
    }

    public double getBalance() {
        return balance;
    }
}
