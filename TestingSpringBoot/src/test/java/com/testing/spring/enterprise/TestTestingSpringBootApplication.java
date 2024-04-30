package com.testing.spring.enterprise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestTestingSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.from(TestingSpringBootApplication::main).with(TestTestingSpringBootApplication.class).run(args);
    }

}
