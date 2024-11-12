package com.assessment.ecf3.dao;

import com.assessment.ecf3.model.Etudiant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EtudiantDAOTest {

    @Autowired
    private EtudiantDAO etudiantDAO;

    @Test
    public void testSaveAndFindById() {
        Etudiant etudiant = new Etudiant(1, "Jean", "Dupont", new ArrayList<>());
        etudiantDAO.save(etudiant);
        Etudiant found = etudiantDAO.findById(1);
        assertEquals("Jean", found.getNom());
    }
}
