package com.assessment.ecf3.service;

import com.assessment.ecf3.dao.NoteDAO;
import com.assessment.ecf3.model.Note;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NoteServiceTest {

    @Mock
    private NoteDAO noteDAO;

    @InjectMocks
    private NoteService noteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void ajouterNote_ShouldAddNote() {
        Note note = new Note();
        when(noteDAO.save(note)).thenReturn(note);

        Note result = noteService.ajouterNote(note);

        assertEquals(note, result);
        verify(noteDAO, times(1)).save(note);
    }

    @Test
    void getNoteById_ShouldReturnNote_WhenNoteExists() {
        Note note = new Note();
        note.setId(1);
        when(noteDAO.findById(1)).thenReturn(Optional.of(note));

        Note result = noteService.getNoteById(1);

        assertEquals(note, result);
    }

    @Test
    void getNoteById_ShouldThrowException_WhenNoteDoesNotExist() {
        when(noteDAO.findById(1)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> noteService.getNoteById(1));
    }
}
