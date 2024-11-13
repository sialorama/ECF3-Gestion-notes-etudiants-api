package com.assessment.ecf3.service;

import com.assessment.ecf3.dao.NoteDAO;
import com.assessment.ecf3.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteDAO noteDAO;

    @Autowired
    public NoteService(NoteDAO noteDAO) {
        this.noteDAO = noteDAO;
    }

    public Note ajouterNote(Note note) {
        return noteDAO.save(note);
    }

    public Note getNoteById(int id) {
        return noteDAO.findById(id).orElseThrow(() -> new IllegalArgumentException("Note introuvable !"));
    }

    public List<Note> getAllNotes() {
        return noteDAO.findAll();
    }

    public void supprimerNoteById(int id) {
        noteDAO.deleteById(id);
    }
}
