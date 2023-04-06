package com.example.project.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@JsonPropertyOrder({ "client_id", "user_name", "membership_id","password", "birthday", "gender", "phone", "email","Addresses"})
@JsonInclude(JsonInclude.Include.ALWAYS)
public class ClientAccount {
    private static int total_accounts=0;
    private String client_id;
    private String user_name;
    private String membership_id=null;
    private String password;
    private String birthday;
    private String gender;
    private String phone;
    private String email;
    private HashMap<String, Address> addresses =new HashMap<String,Address>();
    public ClientAccount(String user_name, String password, String birthday, String gender, String phone, String email, Address address) {
        this.client_id="c"+(total_accounts+1);
        this.user_name = user_name;
        this.password = password;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.email=email;
        addresses.put(address.getId(),address);
        total_accounts++;
    }
    public ClientAccount(String client_id, String user_name, String password, String birthday, String gender, String phone, String email, Address address) {
        this.client_id=client_id;
        this.user_name = user_name;
        this.password = password;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.email=email;
        addresses.put(address.getId(),address);
        total_accounts++;
    }

    @Override
    public String toString() {
        return client_id+","+user_name+","+membership_id+","+birthday+","+gender+","+phone+","+email;
    }

    public static int getTotal_accounts() {
        return total_accounts;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getMembership_id() {
        return membership_id;
    }

    public String getPassword() {
        return password;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress(int id) {
        return addresses.get(id);
    }


    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ResponseBody
    public HashMap<String,Address> getAddresses(){
        return addresses;
    }
}
