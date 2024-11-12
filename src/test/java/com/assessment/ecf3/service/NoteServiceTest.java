package com.assessment.ecf3.service;

import com.assessment.ecf3.dao.NoteDAO;
import com.assessment.ecf3.dao.EtudiantDAO;
import com.assessment.ecf3.model.Cours;
import com.assessment.ecf3.model.Etudiant;
import com.assessment.ecf3.model.Note;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NoteServiceTest {

    @Mock
    private NoteDAO noteDAO;

    @Mock
    private EtudiantDAO etudiantDAO;

    @InjectMocks
    private NoteServiceImpl noteService;

    @Test
    public void testAjouterNote() {
        Etudiant etudiant = new Etudiant();
        etudiant.setId(1);

        Cours cours = new Cours();
        cours.setId(1);

        Note note = new Note();
        note.setValeur(15.5);
        note.setEtudiant(etudiant);
        note.setCours(cours);

        when(noteDAO.save(any(Note.class))).thenReturn(note);

        Note result = noteService.ajouterNote(note);

        assertNotNull(result);
        assertEquals(15.5, result.getValeur(), 0.01);
        verify(noteDAO, times(1)).save(note);
    }
}
