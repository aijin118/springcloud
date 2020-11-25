package cn.siwen.cloud.cloud.Controller;


import cn.siwen.cloud.cloud.entity.CommonResult;
import cn.siwen.cloud.cloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    private  static  final String PAYMENTURL="http://cloud-provider-payment";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consume/payment/{id}")
    public CommonResult<Payment> orderfind(@PathVariable Long id){
     return restTemplate.getForObject(PAYMENTURL+"/payment/find/"+id, CommonResult.class,id);
    }
    @PostMapping(value = "/consume/payment/create")
    public CommonResult<Payment> create(Payment payment){
        System.out.println("Serial-----------------:"+payment.getSerial());
        return restTemplate.postForObject(PAYMENTURL+"/payment/add",payment,CommonResult.class);
    }

}
