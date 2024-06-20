package org.example.autres;

public class WaterTank {
    private static float totalTanks = 0;
    private String nom;
    private float poidsAVide;
    private float capaciteMax;
    private float niveauActuel;

    public WaterTank() {
    }

    public WaterTank(String nom, float poidsAVide, float capaciteMax, float niveauActuel) {
        this.nom = nom;
        this.poidsAVide = poidsAVide;
        this.capaciteMax = capaciteMax;
        this.niveauActuel = Math.min(niveauActuel, capaciteMax);

        totalTanks += this.niveauActuel;
    }

    public float remplir(float eauAjoute){
        float niveauDepart = this.niveauActuel;
        float eauExces =0;

        this.niveauActuel += eauAjoute;

        if(this.niveauActuel > this.capaciteMax){
            eauExces = this.niveauActuel - this.capaciteMax;
            this.niveauActuel = this.capaciteMax;
        }
        totalTanks += this.niveauActuel - niveauDepart;
        return eauExces;
    }

    public float vider(float eauARetirer){
        float niveauDepart = this.niveauActuel;
        float eauRecupere;

        this.niveauActuel -= eauARetirer;
        this.niveauActuel = this.niveauActuel < 0 ? 0 : this.niveauActuel;

        eauRecupere = niveauDepart - this.niveauActuel;
        totalTanks -= eauRecupere;
        return eauRecupere;
    }

    public float getPoidsAVide() {
        return poidsAVide;
    }

    public float getCapaciteMax() {
        return capaciteMax;
    }

    public float getNiveauActuel() {
        return niveauActuel;
    }

    public String getNom() {
        return nom;
    }

    public static float getTotalTanks() {
        return totalTanks;
    }
}
