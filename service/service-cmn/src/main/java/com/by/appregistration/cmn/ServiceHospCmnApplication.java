package com.by.appregistration.cmn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhouboyang
 * @version 1.0
 * @ClassName ServiceHospApplication
 * @description: TODO
 * @date 2022/3/21 23:55
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.by"})
@EnableDiscoveryClient
public class ServiceHospCmnApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceHospCmnApplication.class, args);
    }
}
