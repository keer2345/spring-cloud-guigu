package com.guigu.springcloud.controller;

import com.guigu.springcloud.entity.CommonResult;
import com.guigu.springcloud.entity.Payment;
import com.guigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
  @Resource private PaymentService paymentService;

  @Value("${server.port}")
  private String serverPort;

  //  @PostMapping(value = "/payment/create")
  @RequestMapping(method = RequestMethod.POST, value = "payment/create")
  public CommonResult create(@RequestBody Payment payment) {
    log.info("****JSON: " + payment);
    int result = paymentService.create(payment);
    log.info("****Insert result: " + result);
    if (result > 0) {
      return new CommonResult(200, "insert successful, serverPort: " + serverPort, result);
    } else {
      return new CommonResult(200, "insert failed");
    }
  }

  //  @GetMapping(value = "/payment/get/{id}")
  @RequestMapping(method = RequestMethod.GET, value = "/payment/get/{id}")
  public CommonResult getPaymentById(@PathVariable("id") Long id) {
    Payment payment = paymentService.getPaymentById(id);
    log.info("****Querty result: " + payment);
    if (payment != null) {
      return new CommonResult(200, "query successful, serverPort: " + serverPort, payment);
    } else {
      return new CommonResult(404, "query failed");
    }
  }
}
