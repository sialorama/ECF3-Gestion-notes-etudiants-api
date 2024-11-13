package com.assessment.ecf3.controller;

import com.assessment.ecf3.model.Note;
import com.assessment.ecf3.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public Note ajouterNote(@RequestBody Note note) {
        return noteService.ajouterNote(note);
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable int id) {
        return noteService.getNoteById(id);
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @DeleteMapping("/{id}")
    public void supprimerNoteById(@PathVariable int id) {
        noteService.supprimerNoteById(id);
    }
}
