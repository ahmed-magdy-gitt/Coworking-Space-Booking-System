package com.coworking.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer; // تأكد من الـ import ده

@SpringBootApplication
@EnableEurekaServer // دي اللي بتخلي المشروع يشتغل كـ Server
public class DiscoveryApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryApplication.class, args);
    }
}