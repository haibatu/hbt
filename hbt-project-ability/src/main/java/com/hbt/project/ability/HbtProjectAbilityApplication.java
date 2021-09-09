package com.hbt.project.ability;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication(scanBasePackages = "com.hbt")
//@EnableDiscoveryClient
public class HbtProjectAbilityApplication {
    public static void main(String[] args) {
        SpringApplication.run(HbtProjectAbilityApplication.class, args);
    }

}
