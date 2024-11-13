package com.assessment.ecf3.service;

import com.assessment.ecf3.dao.EtudiantDAO;
import com.assessment.ecf3.model.Etudiant;
import com.assessment.ecf3.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {

    private final EtudiantDAO etudiantDAO;

    @Autowired
    public EtudiantService(EtudiantDAO etudiantDAO) {
        this.etudiantDAO = etudiantDAO;
    }

    public List<Etudiant> getAllEtudiant() {
        return etudiantDAO.findAll();
    }
    public Etudiant ajouterEtudiant(Etudiant etudiant) {
        return etudiantDAO.save(etudiant);
    }

    public Etudiant getEtudiantById(int id) {
        return etudiantDAO.findById(id).orElseThrow(() -> new IllegalArgumentException("Étudiant introuvable !"));
    }

    public List<Note> consulterNotes(int etudiantId) {

        return getEtudiantById(etudiantId).getNotes();
    }

    public Etudiant modifierEtudiant(Etudiant etudiant) {
        return etudiantDAO.save(etudiant);
    }

    public void supprimerEtudiant(int id) {
        etudiantDAO.deleteById(id);
    }

}
