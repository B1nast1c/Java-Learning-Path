package com.example.mainunser.service.implementation;

import com.example.mainunser.dto.MainUserDTO;
import com.example.mainunser.entity.MainUser;
import com.example.mainunser.mapper.MainUserMapper;
import com.example.mainunser.models.Employee;
import com.example.mainunser.models.Enterprise;
import com.example.mainunser.repository.MainUserRepo;
import com.example.mainunser.service.MainUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MainUserServiceImp implements MainUserService {

    @Autowired // El autowired ayuda a crear instancias de elementos de manera correcta y automatica en spring
    private MainUserRepo mainUserRepo; // Para acceder a los datos almacenados

    @Autowired
    private RestTemplate restTemplate; //Una manera de comunicacion entre servicios (Llamada a otro servicio COMUNICA)

    @Override
    public MainUserDTO createUser(MainUserDTO mainUserDTO) {
        MainUser mainUser = MainUserMapper.mapperUser(mainUserDTO);
        MainUser savedMainUser = mainUserRepo.save(mainUser);
        return MainUserMapper.mapperDTO(savedMainUser);
    }

    @Override
    public MainUserDTO getUser(Long id) {
        MainUser mainUser = mainUserRepo.findById(id).orElseThrow(() -> new RuntimeException());
        return MainUserMapper.mapperDTO(mainUser);
    }

    @Override
    public List<MainUserDTO> getAllUsers() {
        return List.of();
    }

    @Override
    public MainUserDTO updateUser(Long id, MainUserDTO mainUserDTO) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    // COMUNICACION DE SERVICIOS

    @Override
    public List<Employee> getEmployeesByUser(Long id) { // NOTA, el puerto usado aqui es el puerto del servicio de employees y asi
        return restTemplate.getForObject(
          "http://localhost:8080/api/employees/user/" + id, List.class //Llama al endpoint de obtener los carros por UserID
        );
    }

    @Override
    public List<Enterprise> getEnterprisesByUser(Long id) {
        return List.of(); // Solamente implementando la de employees es necesario
    }
}
