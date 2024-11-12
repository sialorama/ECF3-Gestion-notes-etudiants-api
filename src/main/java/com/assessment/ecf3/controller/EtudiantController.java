package com.assessment.ecf3.controller;

import com.assessment.ecf3.model.Etudiant;
import com.assessment.ecf3.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @PostMapping
    public Etudiant ajouterEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.ajouterEtudiant(etudiant);
    }

    @GetMapping("/{id}")
    public Etudiant getEtudiant(@PathVariable int id) {
        return etudiantService.getEtudiant(id);
    }

    @GetMapping("/{id}/notes")
    public List<Note> consulterNotes(@PathVariable int id) {
        return etudiantService.consulterNotes(id);
    }
}
