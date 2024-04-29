package com.config.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer // Es un servidor de configuracion
public class ConfigServerSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerSpringApplication.class, args);
    }

}
