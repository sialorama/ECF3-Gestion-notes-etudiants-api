/*
package com.assessment.ecf3.service;
*/
/*
import com.assessment.ecf3.dao.EtudiantDAO;
import com.assessment.ecf3.model.Etudiant;
import com.assessment.ecf3.model.Note;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EtudiantServiceTest {

    @Mock
    private EtudiantDAO etudiantDAO;

    @InjectMocks
    private EtudiantServiceImpl etudiantService;

    @Test
    public void testAjouterEtudiant() {
        Etudiant etudiant = new Etudiant();
        etudiant.setNom("Dupont");
        etudiant.setPrenom("Jean");

        when(etudiantDAO.save(any(Etudiant.class))).thenReturn(etudiant);

        Etudiant result = etudiantService.ajouterEtudiant(etudiant);

        assertNotNull(result);
        assertEquals("Dupont", result.getNom());
        verify(etudiantDAO, times(1)).save(etudiant);
    }

    @Test
    public void testConsulterNotes() {
        Etudiant etudiant = new Etudiant();
        etudiant.setId(1);
        List<Note> notes = Arrays.asList(new Note(), new Note());

        when(etudiantDAO.getNotes(etudiant.getId())).thenReturn(notes);

        List<Note> result = etudiantService.consulterNotes(etudiant.getId());

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(etudiantDAO, times(1)).getNotes(etudiant.getId());
    }*//*

}
*/
