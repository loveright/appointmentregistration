package com.by.appregistration.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.by.appregistration.user.mapper")
public class UserConfig {
}
