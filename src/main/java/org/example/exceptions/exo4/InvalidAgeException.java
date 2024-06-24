package org.example.exceptions.exo4;

//Création de notre Exception personnalisée
//Ici, elle extend RuntimeException (non-surveillé) mais elle aurait pu extend Exception. (choix perso)
public class InvalidAgeException extends RuntimeException{

    //Constructeur de l'exception
    public InvalidAgeException(String message) {
        super(message);
    }
}
