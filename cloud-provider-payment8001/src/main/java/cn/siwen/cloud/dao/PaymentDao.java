package cn.siwen.cloud.dao;

import cn.siwen.cloud.cloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    int addPayment(Payment payment);

    Payment findPaymentById(Long id);
}
