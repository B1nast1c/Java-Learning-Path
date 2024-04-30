package com.testing.spring.enterprise.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "enterprise")
public class Enterprise { //Se crea la tabla y se crean las columnas de la tabla (ENTIDAD)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;;
}
