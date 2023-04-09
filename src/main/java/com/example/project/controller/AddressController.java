package com.example.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.example.project.controller.App_Controller.addresses;

@RestController
public class AddressController {

    @GetMapping("/address/{id}")//浏览器输入http://localhost:8080/address/ad1可以看到传给前端的结果。{}可以使变量id内嵌在网址中
    public ResponseEntity<Object> getAddressById(@PathVariable String id) {
        if (addresses.get(id)==null) { //如果找不到，返回http错误404NOT_FOUND
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
        }
        return ResponseEntity.ok(addresses.get(id));//如果responseEntity找到了，没有报错，就直接返回这个address的对象
    /*http://localhost:8080/address/ad1
    http://localhost:8080/address/ad2
    */
    }

}
