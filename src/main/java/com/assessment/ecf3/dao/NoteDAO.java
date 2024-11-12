package com.assessment.ecf3.dao;

import com.assessment.ecf3.model.Note;

import java.util.List;

public interface NoteDAO {
    Note save(Note note);
    Note findById(int id);
    void delete(int id);
    List<Note> findByStudentId(int etudiantId);
}
