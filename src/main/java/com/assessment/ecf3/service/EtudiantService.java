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

    // Injection d'EtudiantDAO via le constructeur
    @Autowired
    public EtudiantService(EtudiantDAO etudiantDAO) {
        this.etudiantDAO = etudiantDAO;
    }

    public Etudiant ajouterEtudiant(Etudiant etudiant) {
        if (etudiantDAO.findById(etudiant.getId()) != null) {
            throw new IllegalArgumentException("Étudiant existe déjà !");
        }
        return etudiantDAO.save(etudiant);
    }

    public Etudiant getEtudiant(int id) {
        Etudiant etudiant = etudiantDAO.findById(id);
        if (etudiant == null) {
            throw new IllegalArgumentException("Étudiant introuvable !");
        }
        return etudiant;
    }


    public List<Note> consulterNotes(int etudiantId) {
        Etudiant etudiant = getEtudiant(etudiantId);
        return etudiant.getNotes();
    }

    public Etudiant modifierEtudiant(Etudiant etudiant) {
        Etudiant existant = getEtudiant(etudiant.getId());
        existant.setNom(etudiant.getNom());
        existant.setPrenom(etudiant.getPrenom());
        existant.setNotes(etudiant.getNotes());
        return etudiantDAO.save(existant);
    }

    public void supprimerEtudiant(int id) {
        if (etudiantDAO.findById(id) == null) {
            throw new IllegalArgumentException("Étudiant introuvable !");
        }
        etudiantDAO.delete(id);
    }
}
