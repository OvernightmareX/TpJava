package org.example.exceptions;

import java.util.Scanner;

public class Exo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInput;
        int nbInput;

        do{
            System.out.print("Veuillez entrer un nombre : ");
            userInput = sc.nextLine();
            try {
                nbInput = Integer.parseInt(userInput);
                if(nbInput < 0) throw new IllegalArgumentException("Le nombre saisie doit être positif.");
                break;
            } catch (NumberFormatException e){
                System.out.println("Le nombre saisie doit être un nombre entier.");
            } catch (IllegalArgumentException e){
                System.out.println(e);
            }
        }while(true);

        System.out.println("La racine de " + nbInput + " est de " + Math.sqrt(nbInput));
    }
}
