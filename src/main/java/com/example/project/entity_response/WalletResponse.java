package com.example.project.entity_response;

import com.example.project.entity.Wallet;

public class WalletResponse {
    private String status;
    private Wallet wallet;

    public WalletResponse(String status, Wallet wallet) {
        this.status = status;
        this.wallet = wallet;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
