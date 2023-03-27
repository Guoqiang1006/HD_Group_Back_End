package com.example.project.entity_response;

import com.example.project.entity.Client_account;

public class Client_account_response {
        private String status;
        private Client_account client;

        public Client_account_response(String status, Client_account client) {
            this.status = status;
            this.client = client;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Client_account getClient() {
            return client;
        }

        public void setClient(Client_account client) {
            this.client = client;
        }
}