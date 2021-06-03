package com.example.configuration;

import com.example.configuration.service.IndexService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestConfiguration {


    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IndexService bean1 = context.getBean(IndexService.class);
    }

}
