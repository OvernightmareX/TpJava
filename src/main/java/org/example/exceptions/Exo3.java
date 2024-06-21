package org.example.exceptions;

public class Exo3 {
    public static void main(String[] args) {
        int[] tab = {1, 2, 3, 4, 5};

        try {
            System.out.println(tab[10]);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Vous tentez d'accéder à une valeur hors tableau.");
        }
    }
}
