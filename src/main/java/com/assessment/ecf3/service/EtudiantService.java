package com.assessment.ecf3.service;

import com.assessment.ecf3.model.Etudiant;
import java.util.List;

public interface EtudiantService {
    Etudiant ajouterEtudiant(Etudiant etudiant);
    List<Etudiant> getAllEtudiants();
}
