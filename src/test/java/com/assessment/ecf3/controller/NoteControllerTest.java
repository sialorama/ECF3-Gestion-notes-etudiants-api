/*
package com.assessment.ecf3.controller;

import com.assessment.ecf3.model.Note;
import com.assessment.ecf3.service.NoteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@AutoConfigureMockMvc
public class NoteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NoteService noteService;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new NoteController(noteService)).build();
    }

    @Test
    public void testAjouterNote() throws Exception {
        Note note = new Note();
        note.setId(1);
        note.setValeur(15.5);

        when(noteService.ajouterNote(any(Note.class))).thenReturn(note);

        mockMvc.perform(post("/api/notes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"valeur\": 15.5, \"etudiantId\": 1, \"coursId\": 2}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.valeur").value(15.5))
                .andDo(print());
    }

    @Test
    public void testGetNotesByEtudiantId() throws Exception {
        Note note1 = new Note();
        note1.setId(1);
        note1.setValeur(15.5);

        Note note2 = new Note();
        note2.setId(2);
        note2.setValeur(18.0);

        List<Note> notes = Arrays.asList(note1, note2);

        when(noteService.getNotesByEtudiantId(1)).thenReturn(notes);

        mockMvc.perform(get("/api/notes/etudiant/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].valeur").value(15.5))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].valeur").value(18.0))
                .andDo(print());
    }

    @Test
    public void testGetNotesByCoursId() throws Exception {
        Note note1 = new Note();
        note1.setId(1);
        note1.setValeur(15.5);

        Note note2 = new Note();
        note2.setId(2);
        note2.setValeur(16.0);

        List<Note> notes = Arrays.asList(note1, note2);

        when(noteService.getNotesByCoursId(1)).thenReturn(notes);

        mockMvc.perform(get("/api/notes/cours/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].valeur").value(15.5))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].valeur").value(16.0))
                .andDo(print());
    }
}
*/
