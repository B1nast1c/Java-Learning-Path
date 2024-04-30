package com.testing.spring.enterprise.service;

import com.testing.spring.enterprise.dto.EnterpriseDTO;

import java.util.List;

public interface EnterpriseService {
    EnterpriseDTO createEnterprise(EnterpriseDTO enterpriseDTO);
    EnterpriseDTO getEnterprise(Long id);
    List<EnterpriseDTO> getAllEnterprises();
    EnterpriseDTO updateEnterprise(Long id, EnterpriseDTO enterpriseDTO);
    void deleteEnterprise(Long id);
}
