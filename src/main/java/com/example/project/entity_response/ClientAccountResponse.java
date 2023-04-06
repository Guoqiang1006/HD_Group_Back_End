package com.example.project.entity_response;

import com.example.project.entity.ClientAccount;

public class ClientAccountResponse {
        private String status;
        private ClientAccount client;

        public ClientAccountResponse(String status, ClientAccount client) {
            this.status = status;
            this.client = client;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public ClientAccount getClient() {
            return client;
        }

        public void setClient(ClientAccount client) {
            this.client = client;
        }
}