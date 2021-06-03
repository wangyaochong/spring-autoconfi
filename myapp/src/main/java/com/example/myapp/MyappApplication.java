package com.example.myapp;

import com.wyc.ttt.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MyappApplication {

    @Autowired
    Hello hello; //这是注释

    @PostConstruct
    public void init() {
        System.out.println(hello.sayHello());
    }

    public static void main(String[] args) {
        SpringApplication.run(MyappApplication.class, args);
    }

}
