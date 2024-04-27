package com.example.employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee { //Se crea la tabla y se crean las columnas de la tabla (ENTIDAD)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String name;

    @Column(name = "sur_name", nullable = false)
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "userid", nullable = false)
    private Long userid;

}
