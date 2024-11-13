package com.assessment.ecf3.service;

import com.assessment.ecf3.dao.EtudiantDAO;
import com.assessment.ecf3.model.Etudiant;
import com.assessment.ecf3.model.Note;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EtudiantServiceTest {

    @Mock
    private EtudiantDAO etudiantDAO;

    @InjectMocks
    private EtudiantService etudiantService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void ajouterEtudiant_ShouldAddEtudiant() {
        Etudiant etudiant = new Etudiant();
        when(etudiantDAO.save(etudiant)).thenReturn(etudiant);

        Etudiant result = etudiantService.ajouterEtudiant(etudiant);

        assertEquals(etudiant, result);
        verify(etudiantDAO, times(1)).save(etudiant);
    }

    @Test
    void getEtudiant_ShouldReturnEtudiant_WhenEtudiantExists() {
        Etudiant etudiant = new Etudiant();
        etudiant.setId(1);
        when(etudiantDAO.findById(1)).thenReturn(Optional.of(etudiant));

        Etudiant result = etudiantService.getEtudiantById(1);

        assertEquals(etudiant, result);
    }

    @Test
    void getEtudiant_ShouldThrowException_WhenEtudiantDoesNotExist() {
        when(etudiantDAO.findById(1)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> etudiantService.getEtudiantById(1));
    }

    @Test
    void consulterNotes_ShouldReturnListOfNotes() {
        Etudiant etudiant = new Etudiant();
        etudiant.setNotes(new ArrayList<>());
        when(etudiantDAO.findById(1)).thenReturn(Optional.of(etudiant));

        List<Note> result = etudiantService.consulterNotes(1);

        assertNotNull(result);
    }
}
