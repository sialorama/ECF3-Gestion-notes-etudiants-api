package com.assessment.ecf3.service;

import com.assessment.ecf3.dao.EtudiantDAO;
import com.assessment.ecf3.model.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EtudiantServiceImpl implements EtudiantService {
    @Autowired
    private EtudiantDAO etudiantDAO;

    @Override
    public Etudiant ajouterEtudiant(Etudiant etudiant) {
        return etudiantDAO.save(etudiant);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantDAO.findAll();
    }
}
