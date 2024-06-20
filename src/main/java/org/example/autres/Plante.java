package org.example.autres;

public class Plante {
    protected String nom;
    protected float hauteur;
    protected String couleur;

    public Plante() {
    }

    public Plante(String nom, float hauteur, String couleur) {
        this.nom = nom;
        this.hauteur = hauteur;
        this.couleur = couleur;
    }

    public String getNom() {
        return nom;
    }

    public float getHauteur() {
        return hauteur;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setHauteur(float hauteur) {
        this.hauteur = hauteur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Plante{" +
                "nom='" + nom + '\'' +
                ", hauteur=" + hauteur +
                ", couleur='" + couleur + '\'' +
                '}';
    }
}
