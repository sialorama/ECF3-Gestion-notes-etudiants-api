/*
package com.assessment.ecf3.controller;

import com.assessment.ecf3.model.Etudiant;
import com.assessment.ecf3.service.EtudiantService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EtudiantControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EtudiantService etudiantService;

    @Test
    public void testAjouterEtudiantAPI() throws Exception {
        Etudiant etudiant = new Etudiant();
        etudiant.setNom("Dupont");
        etudiant.setPrenom("Jean");

        when(etudiantService.ajouterEtudiant(any(Etudiant.class))).thenReturn(etudiant);

        mockMvc.perform(post("/etudiants")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nom\": \"Dupont\", \"prenom\": \"Jean\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("Dupont"))
                .andExpect(jsonPath("$.prenom").value("Jean"));
    }
}
*/
