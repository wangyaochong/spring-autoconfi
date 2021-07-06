package com.example.remoteconfig;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class MyPropertySourceLocator implements PropertySourceLocator {

    ConfigProperties configProperties;
    public MyPropertySourceLocator(ConfigProperties configProperties){
        this.configProperties = configProperties;
    }

    @Override
    public PropertySource<?> locate(Environment environment) {

        String msg = new SimpleDateFormat("HH:mm:ss").format(new Date());
//  datasource:
//    driver-class-name: com.mysql.cj.jdbc.Driver
//    username: wangyaochong
//    password: qwerqwer
//    url: jdbc:mysql://localhost:3306/tx?useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&&serverTimezone=GMT%2B8
        Map<String, Object> map = new HashMap<>();
        map.put("demo.diy.msg1", "value=" + msg);
        map.put("demo.diy.msg2", "value2=" + msg);
        map.put("spring.datasource.driver-class-name", "com.mysql.cj.jdbc.Driver");
        map.put("spring.datasource.username", "wangyaochong");
        map.put("spring.datasource.password", "qwerqwer");
//        map.put("spring.cloud.config.allowOverride", true);
//        map.put("spring.cloud.config.overrideNone", true);
//        map.put("spring.cloud.config.overrideSystemProperties", false);
        String url="jdbc:mysql://localhost:3306/tx?useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&&serverTimezone=GMT%2B8";
        map.put("spring.datasource.url",url);
        System.out.println("MyPropertySourceLocator, demo.diy.msg = " + msg);

        //spring自带的一个简单的map结构配置集合，也可以继承PropertySource自定义
        MapPropertySource source = new MapPropertySource("my-source", map);
        System.out.println(Arrays.toString(source.getPropertyNames()));
        String property = environment.getProperty("spring.datasource.password");
        String property2 = environment.getProperty("hz.config.server.ip");
        return source;
    }
}
