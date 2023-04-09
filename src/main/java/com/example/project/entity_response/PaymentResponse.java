package com.example.project.entity_response;

import com.example.project.entity.Order;
import com.example.project.entity.Payment;

public class PaymentResponse {
    private String status;
    private Payment payment;

    public PaymentResponse(String status, Payment payment) {
        this.status = status;
        this.payment = payment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
