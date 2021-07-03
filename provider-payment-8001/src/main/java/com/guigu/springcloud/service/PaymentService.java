package com.guigu.springcloud.service;

import com.guigu.springcloud.entiy.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
  public int create(Payment payment);

  public Payment getPaymentById(@Param("id") Long id);
}
