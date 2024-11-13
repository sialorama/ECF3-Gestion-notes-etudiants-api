package com.assessment.ecf3.dao;

import com.assessment.ecf3.model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursDAO extends JpaRepository<Cours, Integer> {
}
