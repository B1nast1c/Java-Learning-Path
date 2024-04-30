package com.testing.spring.enterprise.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnterpriseDTO { // Objeto que almacena los datos durante todos los procesos
    private Long id;
    private String name;
}
