package com.assessment.ecf3.service;

import com.assessment.ecf3.dao.EtudiantDAO;
import com.assessment.ecf3.model.Etudiant;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class EtudiantServiceTest {

    @Mock
    private EtudiantDAO etudiantDAO;

    @InjectMocks
    private EtudiantService etudiantService;

    @Test
    public void testAjouterEtudiant() {
        Etudiant etudiant = new Etudiant(1, "Jean", "Dupont", new ArrayList<>());
        when(etudiantDAO.findById(etudiant.getId())).thenReturn(null); // L'étudiant n'existe pas
        Etudiant result = etudiantService.ajouterEtudiant(etudiant);
        assertNotNull(result);
        verify(etudiantDAO).save(etudiant);
    }
}

