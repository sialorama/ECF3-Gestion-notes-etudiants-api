package com.assessment.ecf3.dao;

import com.assessment.ecf3.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteDAO extends JpaRepository<Note, Integer> {
    // Custom query methods if needed
}
