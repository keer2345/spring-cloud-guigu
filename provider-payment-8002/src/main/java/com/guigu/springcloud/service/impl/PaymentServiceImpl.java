package com.guigu.springcloud.service.impl;

import com.guigu.springcloud.dao.PaymentDao;
import com.guigu.springcloud.entity.Payment;
import com.guigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
  @Resource private PaymentDao paymentDao;

  public int create(Payment payment) {
    return paymentDao.create(payment);
  }

  public Payment getPaymentById(Long id) {
    return paymentDao.getPaymentById(id);
  }
}
