package com.guigu.springcloud.controller;

import com.guigu.springcloud.entity.CommonResult;
import com.guigu.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
  public static final String PAYMENT_URL = "http://localhost:8001";
  @Resource private RestTemplate restTemplate;

  @RequestMapping(method = RequestMethod.POST, value = "/consumer/payment/create")
  public CommonResult<Payment> create(@RequestBody Payment payment) {
    log.info(("Post Consumer: " + payment));
    return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/consumer/payment/get/{id}")
  public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
    log.info("Get Consumer: " + id);
    return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
  }
}
