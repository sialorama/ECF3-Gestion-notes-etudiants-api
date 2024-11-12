package com.assessment.ecf3.model;

import jakarta.persistence.*;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double valeur;

    @ManyToOne
    private Cours cours;

    @ManyToOne
    private Etudiant etudiant;

    // Constructeurs, getters, setters
    public Note() {}

    public Note(double valeur, Cours cours, Etudiant etudiant) {
        this.valeur = valeur;
        this.cours = cours;
        this.etudiant = etudiant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
}
