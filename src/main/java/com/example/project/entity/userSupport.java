package com.example.project.entity;

import java.util.Date;
import java.util.HashMap;

public class userSupport {
    public String type;
    public ClientAccount client;
    public ProviderAccount provider;
    public String status;
    public String ask;

    public String answer=null;

    enum type{
        clientAsk,
        ProviderAsk,
    }
    enum status{
        New,
        Viewed,
        Fninished
    }

}
