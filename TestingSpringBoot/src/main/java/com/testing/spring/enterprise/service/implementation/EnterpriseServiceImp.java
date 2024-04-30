package com.testing.spring.enterprise.service.implementation;

import com.testing.spring.enterprise.dto.EnterpriseDTO;
import com.testing.spring.enterprise.entity.Enterprise;
import com.testing.spring.enterprise.exceptions.NotFoundEnterprise;
import com.testing.spring.enterprise.mapper.EnterpriseMapper;
import com.testing.spring.enterprise.repository.EnterpriseRepo;
import com.testing.spring.enterprise.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnterpriseServiceImp implements EnterpriseService {

    @Autowired // El autowired ayuda a crear instancias de elementos de manera correcta y automatica en spring
    private EnterpriseRepo enterpriseRepo; // Para acceder a los datos almacenados
    public static final String errorMessage = "Not found employee with the id ";

    @Override
    public EnterpriseDTO createEnterprise(EnterpriseDTO enterpriseDTO) {
        Enterprise enterprise = EnterpriseMapper.mapperEmployee(enterpriseDTO);
        Enterprise createdEnterprise = enterpriseRepo.save(enterprise);
        return EnterpriseMapper.mapperDTO(createdEnterprise);
    }

    @Override
    public EnterpriseDTO getEnterprise(Long id) {
        Enterprise enterprise = enterpriseRepo.findById(id).orElseThrow(() -> new NotFoundEnterprise(errorMessage + id));
        return EnterpriseMapper.mapperDTO(enterprise);
    }

    @Override
    public List<EnterpriseDTO> getAllEnterprises() {
        List<Enterprise> enterprises = enterpriseRepo.findAll();
        return enterprises.stream().map(
                EnterpriseMapper::mapperDTO
        ).collect(Collectors.toList());
    }

    @Override
    public EnterpriseDTO updateEnterprise(Long id, EnterpriseDTO enterpriseDTO) {
        Enterprise enterprise = enterpriseRepo.findById(id).orElseThrow(() -> new NotFoundEnterprise(errorMessage + id));
        enterprise.setName(enterpriseDTO.getName());
        enterpriseRepo.save(enterprise);
        return EnterpriseMapper.mapperDTO(enterprise);
    }

    @Override
    public void deleteEnterprise(Long id) {
        enterpriseRepo.findById(id).orElseThrow(() -> new NotFoundEnterprise(errorMessage + id));
        enterpriseRepo.deleteById(id);
    }
}
