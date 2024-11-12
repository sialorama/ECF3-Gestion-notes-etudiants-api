package com.assessment.ecf3.dao;

import com.assessment.ecf3.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantDAO extends JpaRepository<Etudiant, Integer> {
}
