package org.example.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInput = "";
        int nbInput = 0;
        boolean isOk = false;

        do{
            System.out.print("Veuillez entrer un nombre : ");
            userInput = sc.nextLine();
            try {
                nbInput = Integer.parseInt(userInput);
                if(nbInput < 0) throw new IllegalArgumentException();
                isOk = true;
            } catch (NumberFormatException e){
                System.out.println("Le nombre saisie doit être un entier.");
            } catch (IllegalArgumentException e){
                System.out.println("Le nombre saisie doit être positif.");
            }

        }while(!isOk);

        System.out.println("La racine de " + nbInput + " est de " + Math.sqrt(nbInput));
    }
}
