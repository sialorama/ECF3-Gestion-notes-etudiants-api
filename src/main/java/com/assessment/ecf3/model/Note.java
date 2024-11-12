package com.assessment.ecf3.model;

import jakarta.persistence.*;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "etudiant_id") // Colonne pour lier à l'étudiant
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "cours_id") // Colonne pour lier au cours
    private Cours cours;

    private double valeur;

    // Constructeurs
    public Note(int id, Etudiant etudiant, Cours cours, double valeur) {
        this.id = id;
        this.etudiant = etudiant;
        this.cours = cours;
        this.valeur = valeur;
    }

    public Note() {}

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
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
}
