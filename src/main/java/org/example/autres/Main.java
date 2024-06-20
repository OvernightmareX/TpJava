package org.example.autres;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char inputLetter = ' ';
        Pendu p = null;

        PenduIHM.displaySettings();
        p = generatePendu(sc, p);
        PenduIHM.displayGameStart(p);

        do {
            PenduIHM.displayAskLetter();
            inputLetter = sc.nextLine().charAt(0);


        }while (p.getNbTry() != 0);
    }

    private static Pendu generatePendu(Scanner sc, Pendu p) {
        String custom = "";

        do{
            PenduIHM.displayAskCustomTry();
            custom = sc.nextLine();

            if(custom.equalsIgnoreCase("N"))
                p = new Pendu(10, "test");

            if(custom.equalsIgnoreCase("Y")){
                PenduIHM.displayAskHowManyTry();
                p = new Pendu(sc.nextInt(), "test");
            }
        }while (p == null);

        return p;
    }

}