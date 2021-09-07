package com.hbt.project.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HbtProjectGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(HbtProjectGatewayApplication.class);
    }
}
