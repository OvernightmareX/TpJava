package org.example.banque;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BanqueIHM {

    public static void displayMainMenu(Client clt){
        System.out.println("\n=== Menu Principal ===\n");
        System.out.println("1. Lister les comptes bancaires");
        System.out.println("2. Créer un compte bancaire");
        System.out.println("3. Effectuer un dépot");
        System.out.println("4. Effectuer un retrait");
        System.out.println("5. Afficher les opérations et le solde");
        System.out.println("6. Appliquer les intérêts");
        System.out.println("0. Quitter le programme");

        choiceMainMenu(clt);
    }

    public static void displayEnd(Client clt){
        System.out.println("Merci " + clt.getPrenom() + " de votre visite ^^");
    }

    public static void displayAllAccount(Client clt){
        int i = 1;
        System.out.println("=== Liste des comptes ===\n");
        for(CompteBancaire cb : clt.getComptes()){
            System.out.println(Integer.toString(i) + ". " + cb);
            i++;
        }
    }

    public static void displayAccountTypeToCreate(Client clt){
        System.out.println("=== Création de compte ===\n");
        System.out.println("1. Créer un compte courant");
        System.out.println("2. Créer un compte épargne");
        System.out.println("3. Créer un compte payant");
        System.out.println("0. Annuler la création de compte");

        choiceAccountTypeToCreateMenu(clt);
    }

    public static void displayAccountToChoose(Client clt, TypeOperation type){
        int userChoice;

        displayAllAccount(clt);
        displayAllAccountCustomEnding(type);

        userChoice = userChoice(0,clt.getComptes().size());

        if(userChoice == 0)
            return;

        switch (type){
            case DEPOT, RETRAIT -> choiceAmountDepotRetrait(clt.getComptes().get(userChoice-1), type);
            case AFFICHAGE -> displayAccountAllOperations(clt.getComptes().get(userChoice-1));
            case INTERET -> displayAccountInteret(clt.getComptes().get(userChoice-1));
        }
        userSkip();
    }

    private static void displayAccountInteret(CompteBancaire cb){
        double soldeAvantInteret = cb.getSolde();
        if(cb instanceof CompteEpargne){
            System.out.println("Votre compte a un taux d'interet de " + ((CompteEpargne) cb).getTauxInteret() + "%");
            ((CompteEpargne) cb).appliquerInteret();
            System.out.println("Ce qui equivaut a un ajout de " + (cb.getSolde() - soldeAvantInteret));
            System.out.println("Le solde de votre compte est donc de " + cb.getSolde());
        }
        else
            System.out.println("Désoler mais ce compte n'est pas un compte épargne.");
    }

    private static void displayAllAccountCustomEnding(TypeOperation type) {
        switch (type){
            case RETRAIT :
                System.out.println("0. Annuler le retrait");
                System.out.println("\nVeuillez choisir le compte sur lequel vous souhaitez faire un retrait.");
                break;
            case DEPOT :
                System.out.println("0. Annuler le dépôt");
                System.out.println("\nVeuillez choisir le compte sur lequel vous souhaitez faire un dépôt.");
                break;
            case AFFICHAGE :
                System.out.println("0. Annuler l'affichage des opérations ");
                System.out.println("\nVeuillez choisir le compte sur lequel vous souhaitez afficher les opérations.");
                break;
        }
    }

    private static void displayAccountAllOperations(CompteBancaire accountToDisplay) {
        System.out.println("\n=== Affichage des opérations ===\n ");
        for(Operation op : accountToDisplay.getOperations()){
            System.out.println(op);
        }

        System.out.println("Solde du compte : " + accountToDisplay.getSolde());
    }

    public static void choiceAmountDepotRetrait(CompteBancaire cb, TypeOperation type){
        double montant;
        montant = userAmountChoice(type);

        switch (type){
            case DEPOT -> cb.depot(montant);
            case RETRAIT -> cb.retrait(montant);
        }

        if(cb instanceof ComptePayant){
            System.out.println("Etant un compte payant, vous avez eu un cout d'opération de " + ((ComptePayant) cb).getCoutOperation());
            ((ComptePayant) cb).retirerCoutOperation();
        }
        System.out.println("Votre compte a désormais un solde de " + cb.getSolde());
    }

    public static void choiceAccountTypeToCreateMenu(Client clt){
        int inputChoice = userChoice(0,3);

        switch (inputChoice){
            case 1 -> clt.createAccount(0, TypeCompte.COURANT);
            case 2 -> clt.createAccount(0, TypeCompte.EPARGNE);
            case 3 -> clt.createAccount(0, TypeCompte.PAYANT);
            case 0 -> displayMainMenu(clt);
        }
    }

    public static void choiceMainMenu(Client clt){
        int inputChoice = userChoice(0,6);

        switch (inputChoice){
            case 1 -> displayAllAccount(clt);
            case 2 -> displayAccountTypeToCreate(clt);
            case 3 -> displayAccountToChoose(clt, TypeOperation.DEPOT);
            case 4 -> displayAccountToChoose(clt, TypeOperation.RETRAIT);
            case 5 -> displayAccountToChoose(clt, TypeOperation.AFFICHAGE);
            case 6 -> displayAccountToChoose(clt, TypeOperation.INTERET);
        }

        if(inputChoice != 0)
            displayMainMenu(clt);
        else{
            displayEnd(clt);
            return;
        }
    }

    public static void userSkip(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nAppuyer sur 'Entrée' pour continuer.");
        sc.nextLine();
    }

    public static int userChoice(int minChoice, int maxChoice){
        int inputChoice = -1;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Votre choix : ");

            try {
                inputChoice = sc.nextInt();
            }catch (InputMismatchException e ){
                sc.next();
                System.out.println("Vous n'avez pas entrer un entier.");
            }
        }while (inputChoice < minChoice || inputChoice > maxChoice);

        return inputChoice;
    }

    public static double userAmountChoice(TypeOperation type){
        switch (type){
            case DEPOT -> System.out.print("Quelle somme souhaitez-vous déposer : ");
            case RETRAIT -> System.out.print("Quelle somme souhaitez-vous retirer : ");
        }
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }
}
