package com.assessment.ecf3.dao;


import com.assessment.ecf3.model.Etudiant;
import com.assessment.ecf3.model.Note;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EtudiantDAOImpl implements EtudiantDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Etudiant save(Etudiant etudiant) {
        em.persist(etudiant);
        return etudiant;
    }

    @Override
    public Etudiant findById(int id) {
        return em.find(Etudiant.class, id);
    }

    @Override
    public List<Note> getNotes(int etudiantId) {
        // Implémenter la logique pour récupérer les notes associées à un étudiant
        return em.createQuery("SELECT n FROM Note n WHERE n.etudiant.id = :etudiantId", Note.class)
                .setParameter("etudiantId", etudiantId)
                .getResultList();
    }

    @Override
    public void delete(int id) {
        Etudiant etudiant = findById(id);
        if (etudiant != null) {
            em.remove(etudiant);
        }
    }
}
