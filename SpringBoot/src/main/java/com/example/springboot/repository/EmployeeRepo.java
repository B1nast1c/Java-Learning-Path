package com.example.springboot.repository;

import com.example.springboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> { // Employee por el objecto que va a almacenar, y Long por el tipo de dato del ID
}
