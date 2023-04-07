package com.example.project.controller;

import com.example.project.entity.ClientAccount;
import com.example.project.entity_response.ClientAccountResponse;
import org.springframework.web.bind.annotation.*;

import static com.example.project.controller.App_Controller.clients;

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
}
