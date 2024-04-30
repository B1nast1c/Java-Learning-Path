// AYUDA: https://github.com/teddysmithdev/pokemon-review-springboot/blob/master/src/test/java/com/pokemonreview/api/service/PokemonServiceTests.java

package com.testing.spring.enterprise.service;

import com.testing.spring.enterprise.dto.EnterpriseDTO;
import com.testing.spring.enterprise.entity.Enterprise;
import com.testing.spring.enterprise.repository.EnterpriseRepo;
import com.testing.spring.enterprise.service.implementation.EnterpriseServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EnterpriseServiceTest {
    @Mock // Componente dentro de la clase que se va a poner a prueba
    private EnterpriseRepo enterpriseRepo;

    @InjectMocks //La clase principal que está bajo el testing
    private EnterpriseServiceImp enterpriseService;

    private Enterprise defaultEnterprise;

    @BeforeEach
    public void setUp() {
        defaultEnterprise = Enterprise.builder()
                .name("JYP")
                .build();
    }

    @DisplayName("Test SAVE ENTERPRISE")
    @Test
    void testSaveEnterprise() {
        EnterpriseDTO enterpriseDTO = EnterpriseDTO.builder()
                .name(defaultEnterprise.getName()).build();

        Mockito.when(enterpriseRepo.save(Mockito.any(Enterprise.class)) //Cualquier elemento de la clase
        ).thenReturn(defaultEnterprise); // Retorna por defecto

        EnterpriseDTO savedEnterprise = enterpriseService.createEnterprise(enterpriseDTO);
        Assertions.assertThat(savedEnterprise).isNotNull();
    }

}
