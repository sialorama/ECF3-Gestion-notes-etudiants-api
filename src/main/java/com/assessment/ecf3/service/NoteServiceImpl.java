package com.assessment.ecf3.service;

import com.assessment.ecf3.dao.NoteDAO;
import com.assessment.ecf3.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteDAO noteDAO;

    @Override
    public Note ajouterNote(Note note) {
        return noteDAO.save(note);
    }

    @Override
    public List<Note> getAllNotes() {
        return noteDAO.findAll();
    }
}