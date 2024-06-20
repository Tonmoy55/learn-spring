package com.tonmoy.learnspring.config;

import com.tonmoy.learnspring.service.MyFirstClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MyFirstClass myFirstClass() {
        return new MyFirstClass();
    }
}
