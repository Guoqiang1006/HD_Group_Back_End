package com.example.project.controller;

import com.example.project.entity.Wallet;
import com.example.project.entity_response.WalletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.project.controller.App_Controller.wallets;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    @GetMapping("/{id}")//http://localhost:8080/wallet/c1
    public WalletResponse getWalletById(@PathVariable String id) {
        Wallet wallet = wallets.get(id);//根据用户id查找wallet
        if(wallet==null){//如果找不到，返回失败
            return new WalletResponse("fail", null);
        }
        return new WalletResponse("success", wallet);
    }

}
