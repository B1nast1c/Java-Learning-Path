package com.example.mainunser.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Enterprise {
    private String nombre;
    private Long userid; // Entidades de los otros servicios que se encuentran a nombre de la otra entidad mas grande
}
