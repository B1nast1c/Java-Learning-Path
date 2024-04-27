package com.example.mainunser.service;

import com.example.mainunser.dto.MainUserDTO;
import com.example.mainunser.models.Employee;
import com.example.mainunser.models.Enterprise;

import java.util.List;

public interface MainUserService {
    MainUserDTO createUser(MainUserDTO mainUserDTO);
    MainUserDTO getUser(Long id);
    List<MainUserDTO> getAllUsers();
    MainUserDTO updateUser(Long id, MainUserDTO mainUserDTO);
    void deleteUser(Long id);

    //Metodos que conectan los microservicios
    List<Employee> getEmployeesByUser(Long id);
    List<Enterprise> getEnterprisesByUser(Long id);
}
