package com.assessment.ecf3.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String description;
    private int duree;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "etudiant_cours",
            joinColumns = @JoinColumn(name = "cours_id"),
            inverseJoinColumns = @JoinColumn(name = "etudiant_id")
    )
    private List<Etudiant> etudiants;

    public Cours() {}

    public Cours(String nom, String description, int duree) {
        this.nom = nom;
        this.description = description;
        this.duree = duree;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public void addEtudiant(Etudiant etudiant) {
        this.etudiants.add(etudiant);
        etudiant.getCours().add(this);
    }

    public void removeEtudiant(Etudiant etudiant) {
        this.etudiants.remove(etudiant);
        etudiant.getCours().remove(this);
    }

    @Override
    public String toString() {
        return "Cours{id=" + id + ", nom='" + nom + "', description='" + description + "', duree='" + duree + "'}";
    }
}
