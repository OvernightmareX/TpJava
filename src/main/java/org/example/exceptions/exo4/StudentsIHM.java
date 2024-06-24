package org.example.exceptions.exo4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/* A SAVOIR
    Afin de garder un code propre, on essaye de refacto son code en plusieurs méthodes avec un nom clair.
    1 méthode = 1 tâche

    En règle général, si vous avez besoin de commenter ce que votre code fait, alors c'est qu'il n'est pas assez clair.
    Il faut donc revoir le nom de la méthode ou la décomposer en plusieurs méthode ^^
 */

/* TIPS
    Si vous voyez un appel de méthode (ex: userChoice(0,2) ) et que vous voulez savoir ce qu'elle fait sans chercher
    après.
    Appuyer sur CTRL puis clic gauche sur le nom de la méthode. ;)
 */
public class StudentsIHM {
    // On créer une liste static afin qu'elle soit utilisable par nos méthode static.
    // La liste sera donc unique à la classe.
    private static List<Student> students = new ArrayList<>();

    public static void startStudentManager(){
        int userChoice; // Je déclare une variable qui stockera le choix de l'utilisateur dans le menu.

        do{
            displayMainMenu(); // Affichage du menu principal
            userChoice = userChoice(0,2); // Demande une entrée à l'utilisateur

            switch (userChoice){
                case 1 -> displayStudents(); // Si 1, affichage des étudiants présent dans ma liste 'students'
                case 2 -> addStudent(); // Si 2, démarre l'ajout d'un étudiant à la liste

                /*
                    Ici, pas besoin d'un choix par défaut car ma méthode 'userChoice' ne renvoie que les valeurs
                    précisées en paramètre ou -1.
                */
            }

        }while(userChoice != 0); // La boucle s'arrete si l'utilisateur tape '0' => Quitter le programme

        System.out.println("Merci d'avoir utilisé notre programme.");
    }

    // Affichage du menu
    public static void displayMainMenu(){
        System.out.println("\n=== Student manager ===\n");
        System.out.println("1. Afficher les étudiants");
        System.out.println("2. Ajouter un étudiant");
        System.out.println("0. Quitter le programme");
    }

    // Affichage des étudiants avec un foreach.
    public static void displayStudents(){
        int counter = 0;
        System.out.println("=== Affichage des étudiants ===\n");

        /*  RAPPEL FOREACH (parcourir une liste ou un tableau)

              TypeList nomList = new ArrayList<>();

              for(TypeList nomElementDeLaListe : nomList) {

              }
         */
        for(Student student : students){
            System.out.print(++counter + " - "); // ici, j'incrémente 'counter' avant de l'afficher avec le ++ devant.
            System.out.println(student); // Afficher student va appeller la méthode 'ToString' de la classe 'Student'
        }
    }

    // Ajout d'un étudiant
    public static void addStudent(){
        Student student = new Student(); // Création d'un étudiant vide
        userNameInput(student); // Demande un nom à l'utilisateur et l'insère dans 'student'
        userAgeInput(student); // Demande l'age à l'utilisateur et l'insère dans 'student'
        students.add(student); // Ajout de 'student' dans notre liste d'étudiant
    }

    // Demande un nom à l'utilisateur
    public static void userNameInput(Student student){
        Scanner sc = new Scanner(System.in);
        System.out.print("Veuillez entrer le nom de l'étudiant : ");
        student.setName(sc.nextLine()); // Ici, je ne check pas le format de l'entrée (j'accepte les pseudos ^^)
    }

    // Demande l'age à l'utilisateur
    // A une exception près, c'est le contenu de l'exercice 2 que vous pouvez copier-coller ;)
    public static void userAgeInput(Student student){
        Scanner sc = new Scanner(System.in);
        String userInput;
        int nbInput;

        do{
            System.out.print("Veuillez entrer l'age de l'étudiant : ");

            // Ici, on aurait pu mettre sc.nextInt() pour récupérer un 'int' directement.
            // Mais le fait de le convertir après, permet de gérer les exceptions plus facilement.
            userInput = sc.nextLine();

            try {
                nbInput = Integer.parseInt(userInput); // On convertit notre input en Int (si ça marche)
                student.setAge(nbInput); // Exception de l'exo 2 -> Le check du nb négatif ce fait dans le setAge de Student
                break; // Tout marche ! On sort de la boucle \o/

            } catch (NumberFormatException e){ // Si le parseInt renvoie une exception, on le catch ici.
                System.out.println("Le nombre saisie doit être un entier.");

            } catch (InvalidAgeException e){ // Si le setAge renvoie une exception (notre exception perso), on le catch ici.
                System.out.println("Le nombre saisie doit être positif.");
            }
        }while(true);
    }

    // Demande à l'utilisateur de saisir un nombre entier entre 'minChoice' et 'maxChoice'
    public static int userChoice(int minChoice, int maxChoice){

        // inputChoice est initialiser à -1 car je n'ai pas fais de boucle.
        // Je préfére réafficher le menu directement sans harceler l'utilisateur.
        int inputChoice = -1;
        Scanner sc = new Scanner(System.in);

        System.out.println("Votre choix : ");

        try {
            // Comme dit plus haut, on va préférer les nextLine() pour gérer les exceptions mais le nextInt() fonctionne aussi ^^
            inputChoice = sc.nextInt(); // On demande un entier à l'utilisateur.

            // Je vérifie que la valeur entrée est compris dans la range donnée en paramètre.
            if(inputChoice < minChoice || inputChoice > maxChoice) throw new IllegalArgumentException();

        }catch (InputMismatchException e){ // Exception catch si nextInt() ne reçoit pas un entier.
            System.out.println("Vous n'avez pas entrer un entier.\nRetour au menu principal");

        }catch (IllegalArgumentException e){ // Exception catcht si la valeur n'est pas compris entre 'min' et 'max'
            System.out.println("Vous n'avez pas entrer une option correct.\nRetour au menu principal");
        }

        return inputChoice; // retourne -1 ou une valeur comprise entre 'min' et 'max'
    }

}
