package com.example.project.controller;

import com.example.project.entity.ClientAccount;
import com.example.project.entity_response.ClientAccountResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.example.project.controller.App_Controller.clients;

@RestController
public class ClientController {

    @GetMapping("/client")//GetMapping示例2：浏览器输入http://localhost:8080/client?client_id=1可以看到传给前端的结果，这个无default value，根据用户编号查看对应用户信息
    public String getClientStringById(@RequestParam(value = "client_id") String id) {
        return clients.get(id).toString();
    }

    @GetMapping("/client/{id}")//GetMapping示例3：浏览器输入http://localhost:8080/client/c1可以看到传给前端的结果，这个无default value，根据用户编号查看对应用户信息
    public ClientAccountResponse getClientById(@PathVariable String id) {
        ClientAccount client = clients.get(id);//根据id查找account
        if(client==null){//如果找不到，返回失败
            return new ClientAccountResponse("fail", null);
        }
        return new ClientAccountResponse("success", client);//找到了就返回成功加client对象
    }
}
