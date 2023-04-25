package com.example.project.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Date;
import java.util.Objects;

@JsonPropertyOrder({"order_id", "type", "client", "provider", "address", "service_time", "time_order", "time_appointment", "time_start", "time_finish", "amount", "pay", "membership", "voucher", "status" })//初始化json排列方法
@JsonInclude
public class Order {
    //order_id||type||client||provider||address_id||service_time(hours)||time_order||time_appointment||time_start||time_finish||amount||pay#||voucher||status
    private String order_id;
    private String type;
    private ClientAccount client;
    private ProviderAccount provider;
    private Address address;
    private int service_time;
    private Date time_order;
    private Date time_appointment;
    private Date time_start;
    private Date time_finish;
    private double amount;
    private Payment pay;
    private Membership membership;
    private Voucher voucher;
    private String status;

    enum status{
        awaiting,
        servicing,
        serviced
    }

    public Order(String order_id, String type, ClientAccount client, ProviderAccount provider, Address address, int service_time, Date time_order, Date time_appointment, Date time_start, Date time_finish, double amount, Payment pay, Voucher voucher, String status) {
        this.order_id = order_id;
        this.type = type;
        this.client = client;
        this.provider = provider;
        this.address = address;
        this.service_time = service_time;
        this.time_order = time_order;
        this.time_appointment = time_appointment;
        this.time_start = time_start;
        this.time_finish = time_finish;
        this.amount = amount;
        this.pay = pay;
        this.voucher = voucher;
        this.status = status;
    }
    public Order(String order_id, String type, ClientAccount client, ProviderAccount provider, Address address, int service_time, Date time_order, Date time_appointment, Date time_start, Date time_finish, double amount, Membership membership, Voucher voucher, String status) {
        this.order_id = order_id;
        this.type = type;
        this.client = client;
        this.provider = provider;
        this.address = address;
        this.service_time = service_time;
        this.time_order = time_order;
        this.time_appointment = time_appointment;
        this.time_start = time_start;
        this.time_finish = time_finish;
        this.amount = amount;
        this.membership = membership;
        this.voucher = voucher;
        this.status = status;
    }

    public String getOrder_id() {
        return order_id;
    }

    public String getType() {
        return type;
    }

    public ClientAccount getClient() {
        return client;
    }

    public ProviderAccount getProvider() {
        return provider;
    }

    public Address getAddress() {
        return address;
    }

    public int getService_time() {
        return service_time;
    }

    public Date getTime_order() {
        return time_order;
    }

    public Date getTime_appointment() {
        return time_appointment;
    }

    public Date getTime_start() {
        return time_start;
    }

    public Date getTime_finish() {
        return time_finish;
    }

    public double getAmount() {
        return amount;
    }

    public Payment getPay() {
        return pay;
    }

    public Membership getMembership() {
        return membership;
    }

    public Voucher getVoucher() {
        return voucher;
    }

    public String getStatus() {
        return status;
    }

    public void setProvider(ProviderAccount provider) {
        this.provider= provider;
    }

}
