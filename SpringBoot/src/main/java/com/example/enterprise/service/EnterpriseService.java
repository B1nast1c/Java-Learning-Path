package com.example.enterprise.service;

import com.example.enterprise.dto.EnterpriseDTO;

import java.util.List;

public interface EnterpriseService {
    EnterpriseDTO createEnterprise(EnterpriseDTO enterpriseDTO);
    EnterpriseDTO getEnterprise(Long id);
    List<EnterpriseDTO> getAllEnterprises();
    EnterpriseDTO updateEnterprise(Long id, EnterpriseDTO enterpriseDTO);
    void deleteEnterprise(Long id);
}
