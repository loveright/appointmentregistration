package com.by.appregistration.hosp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhouboyang
 * @version 1.0
 * @ClassName ServiceHospApplication
 * @description: TODO
 * @date 2022/3/10 23:18
 */
@SpringBootApplication
//service-hospital模块用到了service-util模块下的Swagger2Config,都是以com.by开头的包
@ComponentScan(basePackages = "com.by")
public class ServiceHospApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceHospApplication.class, args);
    }

}
