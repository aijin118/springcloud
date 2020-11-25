package cn.siwen.cloud.Service.impl;

import cn.siwen.cloud.Service.PaymentService;
import cn.siwen.cloud.dao.PaymentDao;
import cn.siwen.cloud.cloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int addPayment(Payment payment) {
        return paymentDao.addPayment(payment);
    }

    @Override
    public Payment findPaymentById(Long id) {
        return paymentDao.findPaymentById(id);
    }
}
