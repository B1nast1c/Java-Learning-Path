package com.testing.spring.enterprise.repository;

import com.testing.spring.enterprise.entity.Enterprise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

// SOLO EVALUA ENTIDADES Y REPOSITORIOS
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Para hacer el test sobre la base de datos original
@DataJpaTest // Solamente elementos de la capa de persistencia
class EnterpriseRepoTest {

    @Autowired
    private EnterpriseRepo enterpriseRepo;

    private Enterprise defaultEnterprise;

    @BeforeEach
    void setup(){
        defaultEnterprise = Enterprise.builder()
                .name("JYP")
                .build();
    }

    @DisplayName("Guardado de una enterprise")
    @Test
    void testSaveEnterprise() {
        // GIVEN (Condicion previa)
        // CREACION INSTANCIANCIACION CON LOMBOK
        Enterprise enterprise = Enterprise.builder()
                .name("Lorenas Bakery")
                .build();

        // WHEN (Accion + Comportamiento)
        Enterprise savedEnterprise = enterpriseRepo.save(enterprise);

        // THEN (Validacion de la salida)
        assertThat(savedEnterprise.getId()).isNotNull();
        assertThat(savedEnterprise.getName()).isEqualTo("Lorenas Bakery");
    }

    @DisplayName("Test para mostrar todas las ENTERPRISES")
    @Test
    void testFindAllEnterprises() {
        Enterprise enterprise = Enterprise.builder()
                .name("Lorenas Bakery")
                .build();
        enterpriseRepo.save(enterprise);
        enterpriseRepo.save(defaultEnterprise);
        List<Enterprise> enterprises = enterpriseRepo.findAll();

        assertThat(enterprises).hasSize(2);
        assertThat(enterprises.get(0).getName()).isEqualTo("Lorenas Bakery");
        assertThat(enterprises.get(1).getName()).isEqualTo("JYP");
    }

    @DisplayName("Test para obtener enterprise por ID")
    @Test
    void testFindEnterpriseById() {
        enterpriseRepo.save(defaultEnterprise);
        Enterprise enterprise = enterpriseRepo.findById(defaultEnterprise.getId()).get();
        assertThat(enterprise).isNotNull();
    }

    @DisplayName("Test para eliminar un entreprise")
    @Test
    void testDeleteEnterprise() {
        enterpriseRepo.save(defaultEnterprise);
        enterpriseRepo.deleteById(defaultEnterprise.getId());
        Optional<Enterprise> optionalEnterprise = enterpriseRepo.findById(defaultEnterprise.getId());
        assertThat(optionalEnterprise).isEmpty();
    }
}
