package com.assessment.ecf3.model;

public class Cours {
    private int id;
    private String nom;

    // Constructeur
    public Cours(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Cours() {

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
}
