package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.atguigu.springcloud.vo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        log.info("create payment ==> " + payment);
        return paymentService.create(payment) > 0 ? new CommonResult(200, "create success") : new CommonResult(500, "create error");
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id){
        log.info("get payment ==> " + id + "\tserver port " + serverPort);
        Payment payment = paymentService.getPaymentById(id);
        return  payment != null ? new CommonResult(payment, 200, "get success" + serverPort) : new CommonResult(500, "get error" + serverPort);
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        /**
         * 拿到所有的服务单元
         */
        List<String> l2 = discoveryClient.getServices();
        l2.stream().forEach(t -> log.info(t));

        /**
         * 根据服务别名 查找服务单元
         */
        List<ServiceInstance> l1 = discoveryClient.getInstances(l2.get(0));
        l1.stream().forEach(t -> log.info(t.getHost() + "\t" + t.getPort() + "\t" + t.getUri()));
        return this.discoveryClient;
    }

}
