package com.assessment.ecf3.service;

import com.assessment.ecf3.dao.CoursDAO;
import com.assessment.ecf3.model.Cours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursService {

    private final CoursDAO coursDAO;

    @Autowired
    public CoursService(CoursDAO coursDAO) {
        this.coursDAO = coursDAO;
    }

    public List<Cours> getAllCours() {
        return coursDAO.findAll();
    }

    public Cours ajouterCours(Cours cours) {
        return coursDAO.save(cours);
    }

    public Cours getCoursById(int id) {
        return coursDAO.findById(id).orElseThrow(() -> new IllegalArgumentException("Cours non trouvé !"));
    }

    public Cours modifierCours(Cours cours) {
        return coursDAO.save(cours);
    }

    public void supprimerCoursById(int id) {
        coursDAO.deleteById(id);
    }
}
