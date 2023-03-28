package com.example.project;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@ResponseBody
@RestController
public class app_controller {

    private static HashMap<Integer,Client_account> clients = new HashMap<>();
    private static HashMap<Integer,Address> addresses = new HashMap<>();

    public app_controller(){
        Address address=new Address("-34.42463749447153","150.8928590557678","W125/200","Crown St","Wollongong","NSW2500",90.00,100.00);
        Client_account client=new Client_account("Rick","Abc1234567","1999-05-17 00:00:00","Male","0493417283","chenguoqiangsg@gmail.com",address);

        addresses.put(address.getId(),address);
        clients.put(client.getClient_id(), client);
    }
    @GetMapping("/hello")//GetMapping示例1：浏览器输入http://localhost:8080/hello可以看到传给前端的结果。http://localhost:8080/hello?myName=Human。这个方式可以把myName的值从default转为Human。
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
    @GetMapping("/account")//GetMapping示例2：浏览器输入http://localhost:8080/account?account_id=1可以看到传给前端的结果，这个无default value，根据用户编号查看对应用户信息
    public String getClientStringById(@RequestParam(value = "account_id") int id) {
        return clients.get(id).toString();
    }

    @GetMapping("/account/{id}")//GetMapping示例3：浏览器输入http://localhost:8080/account/1可以看到传给前端的结果，这个无default value，根据用户编号查看对应用户信息
    public Client_account_response getClientById(@PathVariable int id) {
        Client_account client = clients.get(id);//根据id查找account
        if(client==null){//如果找不到，返回失败
            return new Client_account_response("fail", null);
        }
        return new Client_account_response("success", client);//找到了就返回成功加client对象
    }
    @GetMapping("/address/{id}")//GetMapping示例4：浏览器输入http://localhost:8080/address/1可以看到传给前端的结果。{}可以使变量id内嵌在网址中
    public ResponseEntity<Object> getAddressById(@PathVariable int id) {
        if (addresses.get(id)==null) { //如果找不到，返回http错误404NOT_FOUND
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
        }
        return ResponseEntity.ok(addresses.get(id));//u如果responseEntity找到了，没有报错，就直接返回这个address的对象
    }
}
