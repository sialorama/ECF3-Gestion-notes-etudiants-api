package com.assessment.ecf3.controller;

import com.assessment.ecf3.model.Etudiant;
import com.assessment.ecf3.service.EtudiantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EtudiantController.class)
class EtudiantControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EtudiantService etudiantService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void ajouterEtudiant_ShouldReturnCreatedEtudiant() throws Exception {
        Etudiant etudiant = new Etudiant();
        etudiant.setNom("John");
        etudiant.setPrenom("Doe");

        when(etudiantService.ajouterEtudiant(any(Etudiant.class))).thenReturn(etudiant);

        mockMvc.perform(post("/etudiants")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(etudiant)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("John"))
                .andExpect(jsonPath("$.prenom").value("Doe"));
    }

    @Test
    void getEtudiant_ShouldReturnEtudiant_WhenEtudiantExists() throws Exception {
        Etudiant etudiant = new Etudiant();
        etudiant.setId(1);
        etudiant.setNom("John");

        when(etudiantService.getEtudiantById(1)).thenReturn(etudiant);

        mockMvc.perform(get("/etudiants/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nom").value("John"));
    }
}
