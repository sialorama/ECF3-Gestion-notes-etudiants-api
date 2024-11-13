package com.assessment.ecf3.controller;

import com.assessment.ecf3.model.Etudiant;
import com.assessment.ecf3.model.Note;
import com.assessment.ecf3.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    private final EtudiantService etudiantService;

    @Autowired
    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }
    // Récupérer tous les Etudiants.
    @GetMapping
    public List<Etudiant> getAllEtudiant() {
        return etudiantService.getAllEtudiant();
    }
    // Ajouter un nouveau étudiant.
    @PostMapping
    public Etudiant ajouterEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.ajouterEtudiant(etudiant);
    }
    // Récupérer un étudiant par son ID.
    @GetMapping("/{id}")
    public Etudiant getEtudiantById(@PathVariable int id) {
        return etudiantService.getEtudiantById(id);
    }
    // Consulter les notes d'un étudiant.
    @GetMapping("/{id}/notes")
    public List<Note> consulterNotes(@PathVariable int id) {
        return etudiantService.consulterNotes(id);
    }
    // Modifier un étudiant existant.
    @PutMapping("/{id}")
    public Etudiant modifierEtudiant(@PathVariable int id, @RequestBody Etudiant etudiant) {
        etudiant.setId(id);
        return etudiantService.modifierEtudiant(etudiant);
    }
    //Supprimer un étudiant par son ID.
    @DeleteMapping("/{id}")
    public void supprimerEtudiant(@PathVariable int id) {
        etudiantService.supprimerEtudiant(id);
    }
}
