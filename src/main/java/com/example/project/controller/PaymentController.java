package com.example.project.controller;

import com.example.project.entity.Payment;
import com.example.project.entity_response.PaymentResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.project.controller.App_Controller.payments;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @GetMapping("/{id}")
    public PaymentResponse getPaymentById(@PathVariable String id) {
        Payment payment = payments.get(id);//根据id查找payment
        if(payment==null){//如果找不到，返回失败
            return new PaymentResponse("fail", null);
        }
        return new PaymentResponse("success", payment);
    }
}
