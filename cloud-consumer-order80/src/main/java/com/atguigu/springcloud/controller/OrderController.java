package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.vo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author fuguofeng
 */
@RestController
@Slf4j
public class OrderController {

    /**
     * 该url写死 如果是服务别名 那么可以通过LoadBalanced注解
     * 实现负载均衡功能
     */
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    /*public static final String PAYMENT_URL = "http://localhost:8001"; 改url被上面的url替代，用LoadBalanced注解RestTemplate上之后，再用服务别名修饰url可以动态实现负载均衡*/

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        log.info("consumer create payment ==> " + payment);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        log.info("consumer get payment ==> " + id);
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

}
