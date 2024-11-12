package com.assessment.ecf3.service;

import com.assessment.ecf3.model.Note;
import java.util.List;

public interface NoteService {
    Note ajouterNote(Note note);
    List<Note> getAllNotes();
}
