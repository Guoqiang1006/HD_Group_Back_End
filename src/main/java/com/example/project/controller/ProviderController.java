package com.example.project.controller;

import com.example.project.entity.ProviderAccount;
import com.example.project.entity_response.ProviderAccountResponse;
import org.springframework.web.bind.annotation.*;

import static com.example.project.controller.App_Controller.providers;

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


}
