package com.assessment.ecf3.service;

import com.assessment.ecf3.dao.CoursDAO;
import com.assessment.ecf3.model.Cours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursService {

    @Autowired
    private CoursDAO coursDAO;

    public Cours ajouterCours(Cours cours) {
        if (cours == null) {
            throw new RuntimeException("Le cours ne peut pas être null");
        }
        return coursDAO.save(cours);
    }

    public Cours getCoursById(Integer id) {
        Optional<Cours> cours = coursDAO.findById(id);
        return cours.orElseThrow(() -> new RuntimeException("Cours non trouvé"));
    }

    public List<Cours> getAllCours() {
        return coursDAO.findAll();
    }

    public Cours modifierCours(Integer id, Cours cours) {
        if (!coursDAO.existsById(id)) {
            throw new RuntimeException("Cours non trouvé");
        }
        cours.setId(id);
        return coursDAO.save(cours);
    }

    public void supprimerCoursById(Integer id) {
        if (!coursDAO.existsById(id)) {
            throw new RuntimeException("Cours non trouvé");
        }
        coursDAO.deleteById(id);
    }
}
