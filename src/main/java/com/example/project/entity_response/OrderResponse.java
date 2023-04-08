package com.example.project.entity_response;

import com.example.project.entity.Order;
import com.example.project.entity.Voucher;

public class OrderResponse {
    private String status;
    private Order order;

    public OrderResponse(String status, Order order) {
        this.status = status;
        this.order = order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
