package com.example.mainunser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients // Para el uso de OpenFeign (COMUNICACION DE MICROSERVICIOS)
@SpringBootApplication
public class MainUserApp {
    public static void main(String[] args) {
        SpringApplication.run(MainUserApp.class, args);
    }
}
