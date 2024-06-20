package org.example.autres;

public class Chaise {
    private int nbPieds;
    private String materiaux;
    private String couleur;
    private float prix;

    public Chaise(){
        this.nbPieds = 4;
        this.materiaux = "chene";
        this.couleur = "bleu";
        this.prix = 14.4f;
    }

    public Chaise(int nbPieds, String materiaux, String couleur, float prix) {
        this.nbPieds = nbPieds;
        this.materiaux = materiaux;
        this.couleur = couleur;
        this.prix = prix;
    }

    public int getNbPieds() {
        return nbPieds;
    }

    public String getMateriaux() {
        return materiaux;
    }

    public String getCouleur() {
        return couleur;
    }

    public float getPrix() {
        return prix;
    }

    public void setNbPieds(int nbPieds) {
        this.nbPieds = nbPieds;
    }

    public void setMateriaux(String materiaux) {
        this.materiaux = materiaux;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Je suis une chaise avec " +
                this.nbPieds + " pied(s) en " +
                this.materiaux + " de couleur " +
                this.couleur + " à un prix de " +
                this.prix + " €";
    }
}
