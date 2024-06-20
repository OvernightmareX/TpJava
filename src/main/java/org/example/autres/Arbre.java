package org.example.autres;

public class Arbre extends Plante{
    private float circonference;

    public Arbre() {
    }

    public Arbre(String nom, float hauteur, String couleur, float circonference) {
        super(nom, hauteur, couleur);
        this.circonference = circonference;
    }

    public float getCirconference() {
        return circonference;
    }

    public void setCirconference(float circonference) {
        this.circonference = circonference;
    }

    @Override
    public String toString() {
        return "Arbre{" +
                "nom='" + this.nom + '\'' +
                ", hauteur=" + this.hauteur +
                ", couleur='" + this.couleur + '\'' +
                ", circonference=" + this.circonference +
                '}';
    }
}
