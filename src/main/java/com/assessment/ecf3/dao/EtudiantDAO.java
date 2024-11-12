package com.assessment.ecf3.dao;

import com.assessment.ecf3.model.Etudiant;
import com.assessment.ecf3.model.Note;

import java.util.List;

public interface EtudiantDAO {
    Etudiant save(Etudiant etudiant);
    Etudiant findById(int id);
    List<Note> getNotes(int etudiantId);
    void delete(int id);
}
