package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.vo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    private static final String INVOKE_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/order/getPaymentzk")
    public CommonResult getPaymentZk(){
        discoveryClient.getServices().stream().forEach(System.out::println);
        final String result = restTemplate.getForObject(INVOKE_URL + "/zk/paymentZk", String.class);
        log.info("result is ==> " + result);
        return new CommonResult(200, result);
    }
}
