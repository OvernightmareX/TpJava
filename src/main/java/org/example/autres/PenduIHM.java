package org.example.autres;

public class PenduIHM {

    public static void displaySettings(){
        System.out.println("=== Paramètres de partie ===\n");
    }

    public static void displayAskCustomTry(){
        System.out.println("Voulez-vous un nombre d'essais spécifique (10 par défaut) ? Y/n ");
    }

    public static void displayAskHowManyTry(){
        System.out.println("Combien voulez-vous d'essais ? ");
    }

    public static void displayGameStart(Pendu p){
        System.out.println("Jeu du pendu généré : Nombre d'essais : " + p.getNbTry());
        displayWordToFind(p.getMask());
        displayRemainingTry(p.getNbTry());
    }

    public static void displayAskLetter(){
        System.out.println("Veuillez saisir une lettre : ");
    }

    public static void displayWordToFind(String mask){
        System.out.println("Le mot à trouver : " + mask);
    }

    public static void displayRemainingTry(int remainingTry){
        System.out.println("Il vous reste "+ remainingTry + " essais");
    }
}
