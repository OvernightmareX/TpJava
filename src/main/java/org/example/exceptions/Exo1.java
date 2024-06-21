package org.example.exceptions;

import java.util.Scanner;

public class Exo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nombre=0;
        String userInput;

        do{
            System.out.print("Veuillez entrer un nombre entier : ");
            userInput = sc.nextLine();
            try {
                nombre = Integer.parseInt(userInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("La saisie n'est pas un entier !");
            }
        }while(true);

        System.out.println("Le nombre entrée est : " + nombre);
    }
}
