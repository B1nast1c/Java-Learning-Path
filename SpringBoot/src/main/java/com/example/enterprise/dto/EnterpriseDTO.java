package com.example.enterprise.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnterpriseDTO { // Objeto que almacena los datos durante todos los procesos
    private Long id;
    private String name;
}
