package com.example.mainunser.mapper;

import com.example.mainunser.dto.MainUserDTO;
import com.example.mainunser.entity.MainUser;


public class MainUserMapper { //Clase que hace el mapeo + CONVERSION DE DTO A ENTIDAD Y ENTIDAD A DTO
    public static MainUserDTO mapperDTO(MainUser mainUser) { //Mapeo de Entidad a DTO
        return new MainUserDTO(
                mainUser.getId(),
                mainUser.getCode()
        );
    }

    public static MainUser mapperUser(MainUserDTO mainUserDTO) { //Mapeo de DTO a Entidad
        return new MainUser(
                mainUserDTO.getId(),
                mainUserDTO.getCode()
        );
    }
}
