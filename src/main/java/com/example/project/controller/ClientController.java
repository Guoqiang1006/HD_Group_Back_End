package com.example.project.controller;

import com.example.project.entity.Address;
import com.example.project.entity.ClientAccount;
import com.example.project.entity.ProviderAccount;
import com.example.project.entity_response.ClientAccountResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

import static com.example.project.controller.App_Controller.clients;
import static com.example.project.controller.App_Controller.addresses;

@RestController
@RequestMapping("/client")
public class ClientController {

    @GetMapping()//GetMapping示例2：浏览器输入http://localhost:8080/client?client_id=c1可以看到传给前端的结果，这个无default value，根据用户编号查看对应用户信息
    public String getClientStringById(@RequestParam(value = "client_id") String id) {
        return clients.get(id).toString();
    }

    @GetMapping("/{id}")//GetMapping示例3：浏览器输入http://localhost:8080/client/c1可以看到传给前端的结果，这个无default value，根据用户编号查看对应用户信息
    public ClientAccountResponse getClientById(@PathVariable String id) {
        ClientAccount client = clients.get(id);//根据id查找account
        if(client==null){//如果找不到，返回失败
            return new ClientAccountResponse("fail", null);
        }
        return new ClientAccountResponse("success", client);//找到了就返回成功加client对象
    }

    //new 25/4

    public void newClient(String user_name, String password, Date birthday, String gender, String phone, String email) {
        ClientAccount client = new ClientAccount(user_name, password,birthday,gender,phone,email);
        clients.put(client.getClient_id(), client);
    }

    public void loginCheck(String user_name, String password) {
        for (ClientAccount client : clients.values()) {
            if (client.getUser_name().equals(user_name) && client.getPassword().equals(password)) {
                System.out.println(user_name+"Login success!");
                return;
            }
        }
        System.out.println("Login failed!");
    }

    public HashMap<String, Address> getAddressList(String user_name) {
        for (ClientAccount client : clients.values()) {
            if (client.getUser_name().equals(user_name)) {
                return client.getAddresses();
            }
        }
        System.out.println("No such user!");
        return null;
    }

    public double selectService(String address_id,String service){
        Address address = addresses.get(address_id);
        switch(service) {
            case "annual":
                return address.getHouse_area()*500;
        }
        return 0;
    }

    public void submitPaymentDetails(String address){

    }
    public void createOrderInfo(String address){

    }

    public HashMap<String, ProviderAccount> getReginalProvider(String address){
        return null;
    }
    public void payMember(String member_id){

    }
    public void oayByOnce(String account_id){

    }
    public void processService(String order_id){

    }


}
