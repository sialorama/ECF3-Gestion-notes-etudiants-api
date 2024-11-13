package com.assessment.ecf3.controller;

import com.assessment.ecf3.model.Cours;
import com.assessment.ecf3.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cours")
public class CoursController {

    @Autowired
    private CoursService coursService;

    @PostMapping
    public Cours ajouterCours(@RequestBody Cours cours) {
        return coursService.ajouterCours(cours);
    }

    @GetMapping("/{id}")
    public Cours getCoursById(@PathVariable Integer id) {
        return coursService.getCoursById(id);
    }

    @GetMapping
    public List<Cours> getAllCours() {
        return coursService.getAllCours();
    }

    @PutMapping("/{id}")
    public Cours modifierCours(@PathVariable Integer id, @RequestBody Cours cours) {
        return coursService.modifierCours(id, cours);
    }

    @DeleteMapping("/{id}")
    public void supprimerCoursById(@PathVariable Integer id) {
        coursService.supprimerCoursById(id);
    }
}
