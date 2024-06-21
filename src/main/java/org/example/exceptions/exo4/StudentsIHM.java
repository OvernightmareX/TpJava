package org.example.exceptions.exo4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentsIHM {
    private static List<Student> students = new ArrayList<>();

    public static void startStudentManager(){
        int userChoice;
        do{
            displayMainMenu();
            userChoice = userChoice(0,3);

            switch (userChoice){
                case 1 -> displayStudents();
                case 2 -> addStudent();
            }

        }while(userChoice != 0);

        System.out.println("Merci d'avoir utilisé notre programme.");
    }

    public static void displayMainMenu(){
        System.out.println("\n=== Student manager ===\n");
        System.out.println("1. Afficher les étudiants");
        System.out.println("2. Ajouter un étudiant");
        System.out.println("0. Quitter le programme");
    }

    public static void displayStudents(){
        int counter = 0;
        for(Student student : students){
            System.out.print(++counter + " - ");
            System.out.println(student);
        }
    }

    public static void addStudent(){
        Student student = new Student();
        userNameInput(student);
        userAgeInput(student);
        students.add(student);
    }

    public static void userAgeInput(Student student){
        Scanner sc = new Scanner(System.in);
        String userInput = "";
        int nbInput = 0;
        boolean isOk = false;

        do{
            System.out.print("Veuillez entrer l'age de l'étudiant : ");
            userInput = sc.nextLine();
            try {
                nbInput = Integer.parseInt(userInput);
                student.setAge(nbInput);
                isOk = true;
            } catch (NumberFormatException e){
                System.out.println("Le nombre saisie doit être un entier.");
            } catch (InvalidAgeException e){
                System.out.println("Le nombre saisie doit être positif.");
            }

        }while(!isOk);
    }

    public static void userNameInput(Student student){
        Scanner sc = new Scanner(System.in);
        System.out.print("Veuillez entrer le nom de l'étudiant : ");
        student.setName(sc.nextLine());
    }

    public static int userChoice(int minChoice, int maxChoice){
        int inputChoice = -1;
        Scanner sc = new Scanner(System.in);

        System.out.println("Votre choix : ");

        try {
            inputChoice = sc.nextInt();
            if(inputChoice < minChoice || inputChoice > maxChoice) throw new IllegalArgumentException();
        }catch (InputMismatchException e){
            sc.next();
            System.out.println("Vous n'avez pas entrer un entier.\nRetour au menu principal");
        }catch (IllegalArgumentException e){
            System.out.println("Vous n'avez pas entrer une option correct.\nRetour au menu principal");
        }

        return inputChoice;
    }

}
