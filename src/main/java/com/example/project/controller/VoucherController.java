package com.example.project.controller;

import com.example.project.entity.Voucher;
import com.example.project.entity_response.VoucherResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.project.controller.App_Controller.vouchers;

@RestController
@RequestMapping("/voucher")
public class VoucherController {
    @GetMapping("/{id}")//http://localhost:8080/voucher/v1
    public VoucherResponse getVouchersById(@PathVariable String id) {
        Voucher voucher =vouchers.get(id);//根据id查找voucher
        if(voucher==null){//如果找不到，返回失败
            return new VoucherResponse("fail", null);
        }
        return new VoucherResponse("success", voucher);
    }
}
