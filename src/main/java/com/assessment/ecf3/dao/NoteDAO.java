package com.assessment.ecf3.dao;

import com.assessment.ecf3.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteDAO extends JpaRepository<Note, Integer> {
}
