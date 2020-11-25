package cn.siwen.cloud.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain8006.class, args);
    }

}
