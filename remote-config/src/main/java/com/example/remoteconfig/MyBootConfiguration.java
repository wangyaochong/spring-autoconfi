package com.example.remoteconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({ConfigProperties.class})
public class MyBootConfiguration {

    //    @Value("${demo.diy.msg1}")
//    String testKey;

    @Autowired
    ConfigProperties configProperties;

    @Bean
    public MyPropertySourceLocator myPropertySourceLocator() {
        return new MyPropertySourceLocator(configProperties);
    }

//    @Bean
//    public PropertySourceBootstrapProperties propertySourceBootstrapProperties() {
//        return new PropertySourceBootstrapProperties();
//    }

//    @Bean
//    public PropertyBean propertyBean() {
//        PropertyBean propertyBean = new PropertyBean();
//        propertyBean.setTestKey(testKey);
//        return propertyBean;
//    }
}
