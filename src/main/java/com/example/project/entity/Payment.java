package com.example.project.entity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Date;

@JsonPropertyOrder({"pay_id", "method", "amount", "time" })//初始化json排列方法
@JsonInclude(JsonInclude.Include.ALWAYS)//初始化内容为空时json传递null
public class Payment {
    //pay_id||method||amount||time
    private String pay_id;
    private String method;
    private double amount;
    private Date time;

    public Payment(String pay_id, String method, double amount, Date time) {
        this.pay_id = pay_id;
        this.method = method;
        this.amount = amount;
        this.time = time;
    }

    public String getPay_id() {
        return pay_id;
    }

    public String getMethod() {
        return method;
    }

    public double getAmount() {
        return amount;
    }

    public Date getTime() {
        return time;
    }
}
