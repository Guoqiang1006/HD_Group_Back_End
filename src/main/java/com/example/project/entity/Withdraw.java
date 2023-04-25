package com.example.project.entity;

import static com.example.project.controller.App_Controller.providers;
public class Withdraw {
    private ProviderAccount provider;
    private double amount;
    private String status;
    enum Status{
        New,
        Viewed,
        Fninished
    }
    public Withdraw(String provider_id, double amount) {
        this.provider = providers.get(provider_id);
        this.amount = amount;
        this.status = "New";
    }
    public ProviderAccount getProvider() {
        return provider;
    }
    public void setProvider(ProviderAccount provider) {
        this.provider = provider;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
}
