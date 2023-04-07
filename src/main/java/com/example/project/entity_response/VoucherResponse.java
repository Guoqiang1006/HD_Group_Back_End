package com.example.project.entity_response;

import com.example.project.entity.ProviderAccount;
import com.example.project.entity.Voucher;
public class VoucherResponse {
    private String status;
    private Voucher voucher;

    public VoucherResponse(String status, Voucher voucher) {
        this.status = status;
        this.voucher = voucher;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }

}
