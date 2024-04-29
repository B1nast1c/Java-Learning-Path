package com.example.mainunser.feignClient;

import com.example.mainunser.models.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "EmployeeService", url = "http://localhost:8080", path = "/api/employees")
public interface EmployeeFeignClient { // Interfaz por cada servicio al que se quiera comunicar

    @PostMapping // Tipo de operacion que se va a efectuar
    // LLAMA AL ENDPOINT POST, QUE NO TIENE NADA EN LA RUTA, HACE UN MAPEO
    public Employee save(@RequestBody Employee employee); // PETICION QUE TIENE UN OBJETO ASI EN EL BODY
}
