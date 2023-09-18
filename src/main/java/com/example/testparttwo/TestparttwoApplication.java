package com.example.testparttwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.testparttwo"})
public class TestparttwoApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestparttwoApplication.class, args);
    }
}