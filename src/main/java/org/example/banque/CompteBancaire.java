package org.example.banque;

import java.util.List;

public abstract class CompteBancaire {
    protected double solde;
    protected Client client;
    protected List<Operation> operations;

    public CompteBancaire() {
    }

    public CompteBancaire(double solde, Client client, List<Operation> operations) {
        this.solde = solde;
        this.client = client;
        this.operations = operations;
    }

    public void depot(double amount){
        this.solde += amount;
        operations.add(new Operation(operations.size()+1, amount, TypeOperation.DEPOT));
    }

    public void retrait(double amount){
        this.solde -= amount;
        operations.add(new Operation(operations.size()+1, amount, TypeOperation.RETRAIT));
    }

    public double getSolde() {
        return solde;
    }

    public Client getClient() {
        return client;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    @Override
    public String toString() {
        return   this.getClass().getSimpleName() + " - " +
                "solde du compte = " + solde +
                ", titulaire du compte = " +
                client.getPrenom()  + " " +
                client.getNom();
    }
}
