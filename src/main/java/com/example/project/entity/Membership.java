package com.example.project.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Date;
import java.util.HashMap;

import static com.example.project.controller.App_Controller.addresses;
import static com.example.project.controller.App_Controller.payments;

@JsonPropertyOrder({"account_id", "membership_id", "account_type", "expire_date", "amount", "address", "payment" })//初始化json排列方法
@JsonInclude(JsonInclude.Include.ALWAYS)//初始化内容为空时json传递null
public class Membership {
    public String account_id;
    public String membership_id;
    public String account_type;
    public Date expire_date;
    public double amount;
    public Address address;
    public Payment payment;

    public Membership(String account_id, String membership_id, String account_type, Date expire_date, double amount,String address,String pay_id) {
        this.account_id = account_id;
        this.membership_id = membership_id;
        this.account_type = account_type;
        this.expire_date = expire_date;
        this.amount = amount;
        this.address = addresses.get(address);
        this.payment=payments.get(pay_id);
    }

    public String getAccount_id() {
        return account_id;
    }

    public String getMembership_id() {
        return membership_id;
    }

    public String getAccount_type() {
        return account_type;
    }

    public Date getExpire_date() {
        return expire_date;
    }

    public double getAmount() {
        return amount;
    }

    public Address getAddress() {
        return address;
    }

    public Payment getPayment() {
        return payment;
    }
}
