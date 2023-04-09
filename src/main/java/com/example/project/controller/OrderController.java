package com.example.project.controller;

import com.example.project.entity.Order;
import com.example.project.entity_response.OrderResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.project.controller.App_Controller.orders;

@RestController
@RequestMapping("/order")
public class OrderController {
    @GetMapping("/{id}")//http://localhost:8080/order/o1
    public OrderResponse getOrdersById(@PathVariable String id) {
        Order order=orders.get(id);//根据id查找order
        if(order==null){//如果找不到，返回失败
            return new OrderResponse("fail", null);
        }
        return new OrderResponse("success", order);
    }
}
