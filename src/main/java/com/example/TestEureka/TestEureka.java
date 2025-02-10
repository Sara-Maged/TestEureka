package com.example.TestEureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableFeignClients
//@EnableDiscoveryClient
@EnableEurekaServer
public class TestEureka {

    public static void main(String[] args) {
        SpringApplication.run(TestEureka.class, args);
    }

}
