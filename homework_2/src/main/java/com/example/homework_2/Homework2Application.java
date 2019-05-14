package com.example.homework_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Homework2Application {

    public static void main(String[] args) {
        SpringApplication.run(Homework2Application.class, args);
    }

}
