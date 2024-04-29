package com.example.mainunser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// Clase Para hacer la comunicacion entre dos microservicios
// RESTTEMPLATE
@Configuration
public class RestTemplateConfig {
    @Bean // Un Bean es un objeto manejado por un orquestador, por ejemplo, un Autowired es un bean, es gestionado por la misma herramienta
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
