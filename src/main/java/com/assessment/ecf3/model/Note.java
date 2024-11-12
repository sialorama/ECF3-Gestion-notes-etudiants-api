package com.assessment.ecf3.model;

public class Note {
    private int id;
    private Cours cours;
    private double valeur;

    // Constructeur
    public Note(int id, Cours cours, double valeur) {
        this.id = id;
        this.cours = cours;
        this.valeur = valeur;
    }

    public Note() {

    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public void setEtudiant(Etudiant etudiant) {

    }
}
