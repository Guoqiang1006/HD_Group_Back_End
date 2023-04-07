package com.example.project.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"voucher_id", "account_type", "voucher_restriction", "voucher_name", "value", "voucher_description" })//初始化json排列方法
@JsonInclude(JsonInclude.Include.ALWAYS)//初始化内容为空时json传递null
public class Voucher {
    private String voucher_id;
    private String account_type;
    private String voucher_restriction;
    private String voucher_name;
    private double value;
    private String voucher_description;

    enum AccountType{
        client,provider
    }
    enum VoucherRestriction{
        onetime, subscription
    }

    public Voucher(String voucher_id, String account_type, String voucher_restriction, String voucher_name, double value, String voucher_description) {
        this.voucher_id = voucher_id;
        this.account_type = account_type;
        this.voucher_restriction = voucher_restriction;
        this.voucher_name = voucher_name;
        this.value = value;
        this.voucher_description = voucher_description;
    }

    public String getVoucher_id() {
        return voucher_id;
    }

    public String getAccount_type() {
        return account_type;
    }

    public String getVoucher_restriction() {
        return voucher_restriction;
    }

    public String getVoucher_name() {
        return voucher_name;
    }

    public double getValue() {
        return value;
    }

    public String getVoucher_description() {
        return voucher_description;
    }
}
