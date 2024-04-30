package com.testing.spring.enterprise.controller;

import com.testing.spring.enterprise.dto.EnterpriseDTO;
import com.testing.spring.enterprise.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enterprises")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService; // El servicio llama a la implementación (Implementation)

    @PostMapping
    public ResponseEntity<EnterpriseDTO> createEnterprise(EnterpriseDTO EnterpriseDTO) {
        EnterpriseDTO enterprise = enterpriseService.createEnterprise(EnterpriseDTO);
        return new ResponseEntity<>(enterprise, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EnterpriseDTO> getEnterprise(@PathVariable("id") Long id) {
        EnterpriseDTO enterprise = enterpriseService.getEnterprise(id);
        return ResponseEntity.ok(enterprise);
    }

    @GetMapping
    public ResponseEntity<List<EnterpriseDTO>> getEnterprises() {
        List<EnterpriseDTO> enterprises = enterpriseService.getAllEnterprises();
        return ResponseEntity.ok(enterprises);
    }

    @PutMapping("{id}")
    public ResponseEntity<EnterpriseDTO> updateEmployee(@PathVariable("id") Long id, @RequestBody EnterpriseDTO EnterpriseDTO) {
        EnterpriseDTO enterprise = enterpriseService.updateEnterprise(id, EnterpriseDTO);
        return ResponseEntity.ok(enterprise);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<EnterpriseDTO> deleteEmployee(@PathVariable("id") Long id) {
        enterpriseService.deleteEnterprise(id);
        return ResponseEntity.noContent().build(); //Objeto vacio
    }
}
