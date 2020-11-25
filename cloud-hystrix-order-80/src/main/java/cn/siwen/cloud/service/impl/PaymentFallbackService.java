package cn.siwen.cloud.service.impl;

import cn.siwen.cloud.service.OrderHystrixService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements OrderHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "服务降级方法";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "服务降级方法";
    }
}
