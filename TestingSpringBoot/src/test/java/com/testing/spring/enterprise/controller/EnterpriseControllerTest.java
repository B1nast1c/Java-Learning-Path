package com.testing.spring.enterprise.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testing.spring.enterprise.dto.EnterpriseDTO;
import com.testing.spring.enterprise.entity.Enterprise;
import com.testing.spring.enterprise.service.EnterpriseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EnterpriseController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class EnterpriseControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EnterpriseService enterpriseService;

    @Autowired
    private ObjectMapper objectMapper;

    private Enterprise defaultEnterprise;
    private EnterpriseDTO defaultEnterpriseDTO;

    @BeforeEach
    void setUp() {
        defaultEnterprise = Enterprise.builder()
                .id(1L)
                .name("JYP")
                .build();

        defaultEnterpriseDTO = EnterpriseDTO.builder()
                .id(2L)
                .name(defaultEnterprise.getName())
                .build();
    }

    @DisplayName("Test SAVE CONTROLLER")
    @Test
    void testSaveController() throws Exception {
        // MOCKEAR EL COMPORTAMIENTO DEL SERVICE
        Mockito.when(enterpriseService.createEnterprise(Mockito.any(EnterpriseDTO.class))).thenReturn(defaultEnterpriseDTO);

        // GIVEN (DADAS LAS CONDICIONES)
        given(
                enterpriseService.createEnterprise(Mockito.any(EnterpriseDTO.class)))
                .willAnswer(
                        invocationOnMock -> invocationOnMock.getArgument(0)
                );

        // SE OBTIENE ESTE RESULTADO (WHEN)
        ResultActions response = mockMvc.perform(post("/api/enterprises")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(defaultEnterpriseDTO)).characterEncoding("utf-8"))
                .andDo(MockMvcResultHandlers.print());

        // SE VALIDA EL RESULTADO
        response
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is(defaultEnterpriseDTO.getName()))); //PQ ES NULO D:
    }
}
