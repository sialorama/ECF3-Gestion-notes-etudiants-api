package com.assessment.ecf3.service;

import com.assessment.ecf3.dao.EtudiantDAO;
import com.assessment.ecf3.dao.NoteDAO;
import com.assessment.ecf3.model.Etudiant;
import com.assessment.ecf3.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EtudiantServiceImpl extends EtudiantService {

    @Autowired
    private EtudiantDAO etudiantDAO;
    @Autowired
    private NoteDAO noteDAO;

    public EtudiantServiceImpl(EtudiantDAO etudiantDAO) {
        super(etudiantDAO);
    }

    @Override
    public Etudiant ajouterEtudiant(Etudiant etudiant) {
        if (etudiantDAO.findById(etudiant.getId()) != null) {
            throw new IllegalArgumentException("Étudiant existe déjà !");
        }
        return etudiantDAO.save(etudiant);
    }

    @Override
    public Etudiant getEtudiant(int id) {
        return etudiantDAO.findById(id);
    }

    @Override
    public List<Note> consulterNotes(int etudiantId) {
        return noteDAO.findByStudentId(etudiantId);
    }
}
