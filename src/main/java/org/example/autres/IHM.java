package org.example.autres;

public class IHM {

    public static void displayVolume(WaterTank w){
        System.out.println("Quantité d'eau dans la "+ w.getNom() + " : " + w.getNiveauActuel());
    }

    public static void displayTotalVolume(){
        System.out.println("Quantité d'eau dans toutes les citernes : " + WaterTank.getTotalTanks());
    }

    public static void displayPoids(WaterTank w){
        System.out.println("Poids total de la " + w.getNom() + " : " + (w.getPoidsAVide() + w.getNiveauActuel()));
    }

    public static void displayLine(){
        System.out.println("-------------------------------------------");
    }

    public static void displayRemplir(WaterTank w, float eauAjoute,float exces){
        System.out.println("Quantité d'eau dans la " + w.getNom() + " après ajout de " + eauAjoute + " litres : " + w.getNiveauActuel() + "/" + w.getCapaciteMax());
        if(exces > 0)
            System.out.println("Excès d'eau recupéré : " + exces);
    }

    public static void displayVider(WaterTank w, float eauARetirer, float eauRecupere){
        System.out.println("Quantité d'eau dans la " + w.getNom() + " après tentative de retrait de " + eauARetirer + " litres : " + w.getNiveauActuel() + "/" + w.getCapaciteMax());
        System.out.println("Quantité d'eau recupéré : " + eauRecupere);
    }
}
