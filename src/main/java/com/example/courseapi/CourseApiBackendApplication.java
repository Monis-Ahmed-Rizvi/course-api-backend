package com.example.courseapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.courseapi")
public class CourseApiBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(CourseApiBackendApplication.class, args);
    }
}