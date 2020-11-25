package cn.siwen.cloud.service;
import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;
@Component
public class PaymentHystrixService {

    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_OK,id: " + id + "\t" + "success";
    }
    //@HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
         //   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value ="3000" )
   // })
    //降级方法
    public String paymentInfo_TimeOut(Integer id) {
        //int timeNumber = 3;
        int age=10/0;
       // try {
          //  TimeUnit.SECONDS.sleep(timeNumber);
      //  } catch (InterruptedException e) {
           // e.printStackTrace();
       // }
        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_TimeOut,id: " + id + "\t" + "success"+"耗时(秒)";
    }
      public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池:" + Thread.currentThread().getName() + "系统繁忙请稍后再试！,id: " + id +"\t"+"┭┮﹏┭┮";
    }

    //10秒之内(窗口,会移动),如果并发==超过==10个,或者10个并发中,失败了6个,就开启熔断器
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数超过峰值，熔断器将会关闭
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable Integer id) {
        if (id < 0) {
            throw new RuntimeException("id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "调用成功,流水号:" + serialNumber;
    }
    //降级方法
    public String paymentCircuitBreaker_fallback(@PathVariable Integer id) {
        return "id 不能负数，请稍后再试, /(ㄒoㄒ)/~~    id" + id;
    }
}

