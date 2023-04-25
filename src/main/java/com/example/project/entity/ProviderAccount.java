package com.example.project.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;

@JsonPropertyOrder({ "provider_id", "user_name", "membership","password", "birthday", "gender", "phone", "email","addresses","pest_removal","weeding","oven_repairs","fence_installation","tree_removal","roof_cleaning","wallet","reviews"})
@JsonInclude(JsonInclude.Include.ALWAYS)
public class ProviderAccount {
    private static int total_providers =0;
    private String provider_id;
    private String user_name;
    private Membership membership=null;
    private String password;
    private Date birthday;
    private String gender;
    private String phone;
    private String email;
    private Wallet wallet;
    private HashMap<String, Address> addresses =new HashMap<>();
    private boolean pest_removal = false;
    private boolean weeding = false;
    private boolean oven_repairs = false;
    private boolean fence_installation = false;
    private boolean tree_removal = false;
    private boolean roof_cleaning = false;
    public HashMap<String,Review> reviews = new HashMap<>();

    public ProviderAccount(String user_name, String password, Date birthday, String gender, String phone, String email){
        this.provider_id="p"+(total_providers +1);
        this.user_name = user_name;
        this.password = password;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.email=email;
        total_providers++;
    }
    public ProviderAccount(String provider_id,String user_name, String password, Date birthday, String gender, String phone, String email, String address, boolean pest_removal, boolean weeding, boolean oven_repairs, boolean fence_installation, boolean tree_removal, boolean roof_cleaning){
        this.provider_id=provider_id;
        this.user_name = user_name;
        this.password = password;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.email=email;
        String[] ads=address.split(",");
        for(String ad:ads){
            addresses.put(ad,null);
        }
        this.pest_removal=pest_removal;
        this.weeding=weeding;
        this.oven_repairs=oven_repairs;
        this.fence_installation=fence_installation;
        this.tree_removal=tree_removal;
        this.roof_cleaning=roof_cleaning;
        total_providers++;
    }
    public void addAddress(Address address){
        addresses.put(address.getId(),address);
    }
    @ResponseBody
    public HashMap<String,Address> getAddresses(){
        return addresses;
    }

    public String getProvider_id() {
        return provider_id;
    }


    public static int getTotal_providers() {
        return total_providers;
    }

    public String getUser_name() {
        return user_name;
    }

    public Membership getMembership() {
        return membership;
    }
    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public String getPassword() {
        return password;
    }

    public Date getBirthday() {
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

    public boolean isPest_removal() {
        return pest_removal;
    }

    public boolean isWeeding() {
        return weeding;
    }

    public boolean isOven_repairs() {
        return oven_repairs;
    }

    public boolean isFence_installation() {
        return fence_installation;
    }

    public boolean isTree_removal() {
        return tree_removal;
    }

    public boolean isRoof_cleaning() {
        return roof_cleaning;
    }

    public void setWallet(Wallet wallet){
        this.wallet=wallet;
    }
    public Wallet getWallet(){
        return wallet;
    }
    public void addReview(String orderId,Review review){
        reviews.put(orderId,review);
    }
    public HashMap<String,Review> getReview(){
        return reviews;
    }
}
