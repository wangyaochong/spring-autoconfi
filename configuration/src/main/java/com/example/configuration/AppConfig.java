package com.example.configuration;

import com.example.configuration.service.IndexService;
import com.example.configuration.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {


    @Bean
    IndexService indexService(){
        System.out.println("index service");
        return new IndexService();
    }

    @Bean
    OrderService orderService() {
        indexService();
        return new OrderService();
    }
}
