package org.example.banque;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {
    private String nom;
    private String prenom;
    private UUID identifiant;
    private List<CompteBancaire> comptes;
    private String numDeTelephone;

    public Client() {
    }

    public Client(String nom, String prenom, List<CompteBancaire> comptes, String numDeTelephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = UUID.randomUUID();
        this.comptes = comptes;
        this.numDeTelephone = numDeTelephone;
    }

    public void createAccount(double solde, TypeCompte type){
        if(comptes == null)
            comptes = new ArrayList<>();

        List<Operation> ops = new ArrayList<>();
        ops.add(new Operation(1, solde, TypeOperation.DEPOT));

        switch (type){
            case COURANT -> comptes.add(new CompteCourant(solde, this, ops));
            case PAYANT -> comptes.add(new ComptePayant(solde, this, ops));
            case EPARGNE -> comptes.add(new CompteEpargne(solde, this, ops));
        }
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public UUID getIdentifiant() {
        return identifiant;
    }

    public List<CompteBancaire> getComptes() {
        return comptes;
    }

    public String getNumDeTelephone() {
        return numDeTelephone;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", identifiant=" + identifiant +
                ", comptes=" + comptes +
                ", numDeTelephone='" + numDeTelephone + '\'' +
                '}';
    }
}
