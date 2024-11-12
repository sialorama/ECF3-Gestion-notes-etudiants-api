package com.assessment.ecf3.model;

import java.util.List;

public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private List<Note> notes;

    // Constructeur
    public Etudiant(int id, String nom, String prenom, List<Note> notes) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.notes = notes;
    }

    public Etudiant() {

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
}
