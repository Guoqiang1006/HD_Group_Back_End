package com.example.project.entity_response;

import com.example.project.entity.ProviderAccount;
public class ProviderAccountResponse{
        private String status;
        private ProviderAccount provider;

        public ProviderAccountResponse(String status, ProviderAccount provider) {
            this.status = status;
            this.provider = provider;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public ProviderAccount getProvider() {
            return provider;
        }

        public void setProvider(ProviderAccount provider) {
            this.provider = provider;
        }

}