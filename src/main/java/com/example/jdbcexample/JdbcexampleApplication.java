package com.example.jdbcexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication

public class JdbcexampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcexampleApplication.class, args);
    }

}
