package com.assessment.ecf3.service;

import com.assessment.ecf3.dao.EtudiantDAO;
import com.assessment.ecf3.model.Etudiant;
import com.assessment.ecf3.model.Note;

import java.util.List;

public abstract class EtudiantService {
    private EtudiantDAO etudiantDAO;

    // Injecter EtudiantDAO via le constructeur ou setter
    public EtudiantService(EtudiantDAO etudiantDAO) {
        this.etudiantDAO = etudiantDAO;
    }

    public Etudiant ajouterEtudiant(Etudiant etudiant) {
        if (etudiantDAO.findById(etudiant.getId()) != null) {
            throw new IllegalArgumentException("Étudiant existe déjà !");
        }
        return etudiantDAO.save(etudiant);
    }

    public abstract Etudiant getEtudiant(int id);

    public List<Note> consulterNotes(int etudiantId) {
        return etudiantDAO.getNotes(etudiantId);
    }

/*    public Etudiant modifierEtudiant(Etudiant etudiant) {
        Etudiant existant = etudiantDAO.findById(etudiant.getId());
        if (existants == null) {
            throw new IllegalArgumentException("Étudiant introuvable !");
        }
        return etudiantDAO.save(etudiant);
    }*/

    public void supprimerEtudiant(int id) {
        etudiantDAO.delete(id);
    }
}
