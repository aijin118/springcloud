package cn.siwen.cloud.Service;

import cn.siwen.cloud.cloud.entity.Payment;

public interface PaymentService {
    int addPayment(Payment payment);

    Payment findPaymentById(Long id);
}
