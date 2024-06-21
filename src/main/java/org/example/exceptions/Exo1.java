package org.example.exceptions;

import java.util.Scanner;

public class Exo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nombre;
        boolean isInt;
        String userInput;

        do{
            userInput = sc.nextLine();
            try {
                nombre = Integer.parseInt(userInput);
                isInt = true;
            } catch (NumberFormatException e) {
                System.out.println("La saisie n'est pas un entier !");
                isInt = false;
            }
        }while(!isInt);
    }
}
