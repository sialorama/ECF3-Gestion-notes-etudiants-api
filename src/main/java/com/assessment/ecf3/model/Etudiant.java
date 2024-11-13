package com.assessment.ecf3.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;

    @JsonManagedReference("etudiant-notes")
    @OneToMany(
            mappedBy = "etudiant",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Note> notes;

    @ManyToMany(
            mappedBy = "etudiants",
            fetch = FetchType.LAZY
    )
    private List<Cours> cours;

    public Etudiant() {}

    public Etudiant(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public List<Cours> getCours() {
        return cours;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }

    @Override
    public String toString() {
        return "Etudiant{id=" + id + ", nom='" + nom + "', prenom='" + prenom + "'}";
    }
}
