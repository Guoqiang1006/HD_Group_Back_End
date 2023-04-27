package com.example.project.controller;

import com.example.project.entity.UserSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/client")
public class UserSuopportController {
    public HashMap<String, UserSupport> getFeedbackList(){
        return null;
    }
    public UserSupport selectUserSupport(String id){
        return null;
    }
    public void setSolution(String id,String solution){
    }

    public void getApplyList(){
    }
    public void selectWithdrawApply(String id){

    }
    public void updateResult(String id,String result){

    }
}
