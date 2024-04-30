package com.testing.spring.enterprise.mapper;

import com.testing.spring.enterprise.dto.EnterpriseDTO;
import com.testing.spring.enterprise.entity.Enterprise;


public class EnterpriseMapper { //Clase que hace el mapeo + CONVERSION DE DTO A ENTIDAD Y ENTIDAD A DTO
    public static EnterpriseDTO mapperDTO(Enterprise enterprise) { //Mapeo de Entidad a DTO
        return new EnterpriseDTO(
                enterprise.getId(),
                enterprise.getName()
        );
    }

    public static Enterprise mapperEmployee(EnterpriseDTO enterpriseDTO) { //Mapeo de DTO a Entidad
        return new Enterprise(
                enterpriseDTO.getId(),
                enterpriseDTO.getName()
        );
    }
}
