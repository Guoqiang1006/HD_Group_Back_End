package com.example.project.controller;

import com.example.project.entity.Address;
import com.example.project.entity.Order;
import com.example.project.entity.ProviderAccount;
import com.example.project.entity_response.ProviderAccountResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

import static com.example.project.controller.App_Controller.*;

@RestController
@RequestMapping("/provider")
public class ProviderController {
    @GetMapping("/{id}")//http://localhost:8080/provider/p1
    public ProviderAccountResponse getProviderById(@PathVariable String id) {
        ProviderAccount provider = providers.get(id);//根据id查找account
        if(provider==null){//如果找不到，返回失败
            return new ProviderAccountResponse("fail", null);
        }
        return new ProviderAccountResponse("success", provider);//找到了就返回成功加client对象
    }

    @PostMapping("/new")//http://localhost:8080/provider/new
    public ProviderAccount newProvider(String user_name, String password, Date birthday, String gender, String phone, String email){
        ProviderAccount provider= new ProviderAccount(user_name,password,birthday,gender,phone,email);
        providers.put(provider.getProvider_id(),provider);
        System.out.println(provider.getProvider_id()+" is added!");
        return provider;
    }

    public HashMap<String, Address> getAddressList(String user_id){
        for(ProviderAccount provider:providers.values()){
            if(provider.getProvider_id().equals(user_id)){
                return provider.getAddresses();
            }
        }
        return null;
    }
    public double selectService(String address_id){
        return 99.99;
    }
    public String submitPaymentDetail(String address_id,String payment_detail){
        return "success";
    }
    public HashMap<String, Order> getAllOrderList(String Provider_id){
        HashMap<String, Order> re_orders = new HashMap<>();
        for(Order order: orders.values()){
            if(order.getProvider()==null){
                re_orders.put(order.getOrder_id(),order);
            }
        }
        return re_orders;
    }

    public Order selectOrder(String provider_id,String order_id){
        orders.get(order_id).setProvider(providers.get(provider_id));
        return orders.get(order_id);
    }
    public HashMap<String, Order> getOrderDetails(String provider_id,String order_id){
        HashMap<String, Order> re_orders = new HashMap<>();
        for(Order order: orders.values()){
            if(order.getProvider().getProvider_id().equals(provider_id)){
                re_orders.put(order.getOrder_id(),order);
            }
        }
        return re_orders;
    }
    public String setWithdrawAmount(String provider_id,double amount){
        if(providers.get(provider_id).getWallet().getBalance()>amount){
            return "withdraw success";
        }
        return "failed";
    }


}
