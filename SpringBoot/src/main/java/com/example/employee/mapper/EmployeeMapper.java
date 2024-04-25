package com.example.employee.mapper;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.entity.Employee;


public class EmployeeMapper { //Clase que hace el mapeo + CONVERSION DE DTO A ENTIDAD Y ENTIDAD A DTO
    public static EmployeeDTO mapperDTO(Employee employee) { //Mapeo de Entidad a DTO
        return new EmployeeDTO(
                employee.getId(),
                employee.getName(),
                employee.getSurname(),
                employee.getEmail()
        );
    }

    public static Employee mapperEmployee(EmployeeDTO employeeDTO) { //Mapeo de DTO a Entidad
        return new Employee(
                employeeDTO.getId(),
                employeeDTO.getName(),
                employeeDTO.getSurname(),
                employeeDTO.getEmail()
        );
    }
}
