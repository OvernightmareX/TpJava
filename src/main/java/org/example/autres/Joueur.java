package org.example.autres;

public class Joueur {
    private String nom;
    private int niveau;
    private int exp;

    public Joueur() {
        this.nom = "Pinpin";
        this.niveau = 1;
        this.exp = 0;
    }

    public Joueur(String nom, int niveau, int exp) {
        this.nom = nom;
        this.niveau = niveau;
        this.exp = exp;
    }

    public void effectuerUneQuete(){
        this.exp += 10;
        levelUp();
    }

    public void levelUp(){
        if(this.exp > 100){
            this.niveau++;
            this.exp = 0;
            System.out.println("Le joueur "+ this.nom + " passe au niveau " + this.niveau);
        }
    }

    public String getNom() {
        return nom;
    }

    public int getNiveau() {
        return niveau;
    }

    public int getExp() {
        return exp;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "nom='" + nom + '\'' +
                ", niveau=" + niveau +
                ", exp=" + exp +
                '}';
    }
}
