package com.guigu.springcloud.controller;

import com.guigu.springcloud.entity.CommonResult;
import com.guigu.springcloud.entity.Payment;
import com.guigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
  @Resource private PaymentService paymentService;

  @PostMapping(value = "/payment/create")
  public CommonResult create(Payment payment) {
    int result = paymentService.create(payment);
    log.info("****插入结果: " + result);
    if (result > 0) {
      return new CommonResult(200, "insert successful", result);
    } else {
      return new CommonResult(200, "insert failed");
    }
  }

  @GetMapping(value = "/payment/get/{id}")
  public CommonResult getPaymentById(@PathVariable("id") Long id) {
    Payment payment = paymentService.getPaymentById(id);
    log.info("****查询结果: " + payment);
    if (payment != null) {
      return new CommonResult(200, "query successful", payment);
    } else {
      return new CommonResult(404, "query failed");
    }
  }
}
