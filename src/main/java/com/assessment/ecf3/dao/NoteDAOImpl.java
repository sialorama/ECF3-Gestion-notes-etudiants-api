package com.assessment.ecf3.dao;

import com.assessment.ecf3.model.Note;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class NoteDAOImpl implements NoteDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Note save(Note note) {
        em.persist(note);
        return note;
    }

    @Override
    public Note findById(int id) {
        return em.find(Note.class, id);
    }

    @Override
    public void delete(int id) {
        Note note = findById(id);
        if (note != null) {
            em.remove(note);
        }
    }

    @Override
    public List<Note> findByStudentId(int etudiantId) {
        return em.createQuery("SELECT n FROM Note n WHERE n.etudiant.id = :etudiantId", Note.class)
                .setParameter("etudiantId", etudiantId)
                .getResultList();
    }
}
