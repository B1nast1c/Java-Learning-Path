package com.example.mainunser.controller;

import com.example.mainunser.dto.MainUserDTO;
import com.example.mainunser.models.Employee;
import com.example.mainunser.service.MainUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class MainUserController {

    @Autowired
    private MainUserService mainUserService; // El servicio llama a la implementación (Implementation)

    @PostMapping
    public ResponseEntity<MainUserDTO> createMainUser(@RequestBody MainUserDTO mainUserDTO) {
        MainUserDTO mainUser = mainUserService.createUser(mainUserDTO);
        return new ResponseEntity<>(mainUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<MainUserDTO> getMainUser(@PathVariable("id") Long id) {
        MainUserDTO mainUserDTO = mainUserService.getUser(id);
        return ResponseEntity.ok(mainUserDTO);
    }

    @GetMapping("/employees/{userId}") //Usado cuando un servicio llama a otro
    public ResponseEntity<List<Employee>> getEmployeesByUser(@PathVariable("userId") Long userid) {
        // Primero obtienes el usuario
        MainUserDTO mainUser = mainUserService.getUser(userid);
        if (mainUser == null) {
            return ResponseEntity.notFound().build();
        }

        List<Employee> employees = mainUserService.getEmployeesByUser(userid); // Hace la llamada que llama al otro endpoint jsjsj
        return ResponseEntity.ok(employees);
    }
}
