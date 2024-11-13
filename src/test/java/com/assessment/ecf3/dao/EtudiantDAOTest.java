package com.assessment.ecf3.dao;

import com.assessment.ecf3.model.Etudiant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class EtudiantDAOTest {

    @Autowired
    private EtudiantDAO etudiantDAO;

    private Etudiant etudiant;

    @BeforeEach
    void setUp() {
        // Initialisation d'un étudiant pour les tests
        etudiant = new Etudiant();
        etudiant.setNom("Doe");
        etudiant.setPrenom("John");
        etudiantDAO.save(etudiant);
    }

    @Test
    void save_ShouldPersistEtudiant() {
        Etudiant newEtudiant = new Etudiant();
        newEtudiant.setNom("Smith");
        newEtudiant.setPrenom("Anna");

        Etudiant savedEtudiant = etudiantDAO.save(newEtudiant);

        assertNotNull(savedEtudiant.getId());
        assertEquals("Smith", savedEtudiant.getNom());
        assertEquals("Anna", savedEtudiant.getPrenom());
    }

    @Test
    void findById_ShouldReturnEtudiant_WhenEtudiantExists() {
        Optional<Etudiant> foundEtudiant = etudiantDAO.findById(etudiant.getId());

        assertTrue(foundEtudiant.isPresent());
        assertEquals("Doe", foundEtudiant.get().getNom());
        assertEquals("John", foundEtudiant.get().getPrenom());
    }

    @Test
    void findById_ShouldReturnEmpty_WhenEtudiantDoesNotExist() {
        Optional<Etudiant> foundEtudiant = etudiantDAO.findById(-1);

        assertFalse(foundEtudiant.isPresent());
    }

    @Test
    void findAll_ShouldReturnListOfEtudiants() {
        List<Etudiant> etudiants = etudiantDAO.findAll();

        assertFalse(etudiants.isEmpty());
        assertEquals(1, etudiants.size());
        assertEquals("Doe", etudiants.get(0).getNom());
    }

    @Test
    void deleteById_ShouldRemoveEtudiant() {
        etudiantDAO.deleteById(etudiant.getId());

        Optional<Etudiant> deletedEtudiant = etudiantDAO.findById(etudiant.getId());

        assertFalse(deletedEtudiant.isPresent());
    }
}
