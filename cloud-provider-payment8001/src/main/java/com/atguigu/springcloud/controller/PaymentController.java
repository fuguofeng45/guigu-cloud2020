package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.atguigu.springcloud.vo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author fuguofeng
 */
@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        log.info("create payment ==> " + payment);
        return paymentService.create(payment) > 0 ? new CommonResult(200, "create success") : new CommonResult(500, "create error");
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id){
        log.info("get payment ==> " + id + "\tserver port " + serverPort);
        Payment payment = paymentService.getPaymentById(id);
        return  payment != null ? new CommonResult(payment, 200, "get success") : new CommonResult(500, "get error");
    }

}
