package com.assessment.ecf3.controller;

import com.assessment.ecf3.model.Cours;
import com.assessment.ecf3.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping( "/api/cours")
public class CoursController {

    private final CoursService coursService;

    @Autowired
    public CoursController(CoursService coursService) {
        this.coursService = coursService;
    }
    // Récupérer tous les cours.
    @GetMapping
    public List<Cours> getAllCours() {
        return coursService.getAllCours();
    }
     // Ajouter un nouveau cours.
    @PostMapping
    public Cours ajouterCours(@RequestBody Cours cours) {
        return coursService.ajouterCours(cours);
    }
    // Récupérer un cours par son ID.
    @GetMapping("/{id}")
    public Cours getCoursById(@PathVariable int id) {
        return coursService.getCoursById(id);
    }
    // Modifier un cours par son ID.
    @PutMapping("/{id}")
    public Cours modifierCours(@PathVariable Integer id, @RequestBody Cours cours) {
        return coursService.modifierCours(id, cours);
    }
    //Supprimer un cours par son ID.
    @DeleteMapping("/{id}")
    public void supprimerCoursById(@PathVariable Integer id) {
        coursService.supprimerCoursById(id);
    }
}
