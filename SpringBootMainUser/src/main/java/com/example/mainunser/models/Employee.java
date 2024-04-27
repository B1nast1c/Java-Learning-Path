package com.example.mainunser.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee { //Los modelos son los que tienen el id
    private String name;
    private String surname;
    private String email;
    private Long userid;
}
