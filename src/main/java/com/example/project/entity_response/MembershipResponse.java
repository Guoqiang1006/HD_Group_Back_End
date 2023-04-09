package com.example.project.entity_response;

import com.example.project.entity.Membership;
import com.example.project.entity.Payment;

public class MembershipResponse {
    private String status;
    private Membership membership;
    public MembershipResponse(String status, Membership membership) {
        this.status = status;
        this.membership = membership;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Membership getMembership() {
        return membership;
    }
    public void setMembership(Membership membership) {
        this.membership = membership;
    }
}
