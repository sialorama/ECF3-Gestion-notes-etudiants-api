package com.assessment.ecf3.controller;

import com.assessment.ecf3.model.Cours;
import com.assessment.ecf3.model.Note;
import com.assessment.ecf3.service.NoteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(NoteController.class)
class NoteControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NoteService noteService;

    @Autowired
    private ObjectMapper objectMapper;

    private Cours cours;

    @BeforeEach
    void setUp() {
        // Initialisation d'un objet Cours pour être utilisé dans les tests
        cours = new Cours();
        cours.setId(1);
        cours.setNom("Math");
    }

    @Test
    void ajouterNote_ShouldReturnCreatedNote() throws Exception {
        Note note = new Note();
        note.setCours(cours);  // Utiliser un objet Cours au lieu d'une chaîne
        note.setValeur(15.5);

        when(noteService.ajouterNote(any(Note.class))).thenReturn(note);

        mockMvc.perform(post("/notes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(note)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cours.nom").value("Math"))
                .andExpect(jsonPath("$.valeur").value(15.5));
    }

    @Test
    void getNoteById_ShouldReturnNote_WhenNoteExists() throws Exception {
        Note note = new Note();
        note.setId(1);
        note.setCours(cours);  // Utiliser un objet Cours
        note.setValeur(12.0);

        when(noteService.getNoteById(1)).thenReturn(note);

        mockMvc.perform(get("/notes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.cours.nom").value("Math"))
                .andExpect(jsonPath("$.valeur").value(12.0));
    }
}
