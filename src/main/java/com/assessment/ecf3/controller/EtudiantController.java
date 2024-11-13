package com.assessment.ecf3.controller;

import com.assessment.ecf3.model.Etudiant;
import com.assessment.ecf3.model.Note;
import com.assessment.ecf3.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    private final EtudiantService etudiantService;

    @Autowired
    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

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

    @PutMapping("/{id}")
    public Etudiant modifierEtudiant(@PathVariable int id, @RequestBody Etudiant etudiant) {
        etudiant.setId(id);
        return etudiantService.modifierEtudiant(etudiant);
    }

    @DeleteMapping("/{id}")
    public void supprimerEtudiant(@PathVariable int id) {
        etudiantService.supprimerEtudiant(id);
    }
}
