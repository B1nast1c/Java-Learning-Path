package com.example.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO { // Objeto que almacena los datos durante todos los procesos
    private Long id;
    private String name;
    private String surname;
    private String email;
}
