package com.assessment.ecf3.service;

import com.assessment.ecf3.model.Note;

public interface NoteService {
    Note ajouterNote(Note note);
    void supprimerNote(int id);
}
