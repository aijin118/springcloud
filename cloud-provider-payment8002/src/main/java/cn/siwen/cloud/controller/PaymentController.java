package cn.siwen.cloud.controller;

import cn.siwen.cloud.Service.PaymentService;
import cn.siwen.cloud.cloud.entity.CommonResult;
import cn.siwen.cloud.cloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/add")
    public CommonResult addPayment(@RequestBody Payment payment) {
        System.out.println("serial********************:"+payment.getSerial());
        int result = paymentService.addPayment(payment);
        System.out.println("result********************:"+result);
        if (result > 0) {
            return new CommonResult(200, "success", payment);
        } else {
            return new CommonResult(888, "faild");
        }
    }

    @GetMapping("/payment/find/{id}")
    public CommonResult findPayment(@PathVariable Long id){
        Payment payment=paymentService.findPaymentById(id);
        if(payment !=null){
            return new CommonResult(200, "success/查询ID:"+id, payment);
        }else {
            return new CommonResult(999, "faild");
        }
    }
}
