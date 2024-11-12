package com.assessment.ecf3.controller;

import com.assessment.ecf3.model.Etudiant;
import com.assessment.ecf3.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    // Endpoint pour ajouter un étudiant (méthode POST)
    @PostMapping
    public ResponseEntity<Etudiant> ajouterEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant createdEtudiant = etudiantService.ajouterEtudiant(etudiant);
        return new ResponseEntity<>(createdEtudiant, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Etudiant getEtudiant(@PathVariable int id) {
        return etudiantService.getEtudiant(id);
    }
}
