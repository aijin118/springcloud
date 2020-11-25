package cn.siwen.cloud.controller;

import cn.siwen.cloud.service.OrderHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import jdk.internal.instrumentation.Logger;

import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Log4j2
public class OrderHystrixController {

    @Resource
    private OrderHystrixService OrderhystrixService;

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = OrderhystrixService.paymentInfo_OK(id);
        log.info("*******result:"+result);
        return result;
    }
   @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value ="1500" )
//    })

    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = OrderhystrixService.paymentInfo_TimeOut(id);
        log.info("*******result:"+result);
        return result;
    }
   public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "我是消费者81，对方支付系统繁忙请10秒钟后再试或者自己运行错误请检查！";

    }

}