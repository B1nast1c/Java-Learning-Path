package com.example.springboot.service.implementation;

import com.example.springboot.dto.EmployeeDTO;
import com.example.springboot.entity.Employee;
import com.example.springboot.exceptions.NotFoundEmployee;
import com.example.springboot.mapper.EmployeeMapper;
import com.example.springboot.repository.EmployeeRepo;
import com.example.springboot.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private View error;

    @Autowired // El autowired ayuda a crear instancias de elementos de manera correcta y automatica en spring
    private EmployeeRepo employeeRepo; // Para acceder a los datos almacenados
    public static final String errorMessage = "Not found employee with the id ";

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) { // De un DTO Genera un objeto employee, pasado again a un DTO
        Employee employee = EmployeeMapper.mapperEmployee(employeeDTO);
        Employee savedEmployee = employeeRepo.save(employee);
        return EmployeeMapper.mapperDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployee(Long id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new NotFoundEmployee(errorMessage + id));
        return EmployeeMapper.mapperDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        return employees.stream().map(
                EmployeeMapper::mapperDTO).collect(Collectors.toList()); // Uso de programacion funcional, transforma de employees a el DTO
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new NotFoundEmployee(errorMessage + id));
        employee.setName(employeeDTO.getName());
        employee.setSurname(employeeDTO.getSurname());
        employee.setEmail(employeeDTO.getEmail());

        Employee updatedEmployee = employeeRepo.save(employee);
        return EmployeeMapper.mapperDTO(updatedEmployee);

    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepo.findById(id).orElseThrow(() -> new NotFoundEmployee(errorMessage + id));
        employeeRepo.deleteById(id);
    }
}
