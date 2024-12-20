package com.assessment.ecf3.dao;

import com.assessment.ecf3.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantDAO extends JpaRepository<Etudiant, Integer> {
    // Custom query methods if needed
}
