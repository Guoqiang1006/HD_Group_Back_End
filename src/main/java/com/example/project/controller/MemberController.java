package com.example.project.controller;

import com.example.project.entity.Membership;
import com.example.project.entity_response.MembershipResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.project.controller.App_Controller.memberships;

@RestController
@RequestMapping("/membership")
public class MemberController {
    @GetMapping("/{id}")
    public MembershipResponse getPaymentById(@PathVariable String id) {
        Membership membership = memberships.get(id);//根据id查找membership
        if(membership==null){//如果找不到，返回失败
            return new MembershipResponse("fail", null);
        }
        return new MembershipResponse("success", membership);
    }
}
