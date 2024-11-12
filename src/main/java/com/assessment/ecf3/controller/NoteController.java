package com.assessment.ecf3.controller;

import com.assessment.ecf3.model.Note;
import com.assessment.ecf3.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping
    public Note ajouterNote(@RequestBody Note note) {
        return noteService.ajouterNote(note);
    }

    @DeleteMapping("/{id}")
    public void supprimerNote(@PathVariable int id) {
        noteService.supprimerNote(id);
    }

/*    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }*/
}

