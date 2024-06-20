package org.example.banque;

import java.util.List;

public class CompteEpargne extends CompteBancaire{
    private double tauxInteret;

    public CompteEpargne() {
    }

    public CompteEpargne(double solde, Client client, List<Operation> operations, double tauxInteret) {
        super(solde, client, operations);
        this.tauxInteret = tauxInteret;
    }

    public void appliquerInteret(){
        double montantInteret = this.solde * (tauxInteret/100);
        operations.add(new Operation(operations.size()+1, montantInteret, TypeOperation.DEPOT));
        this.solde += montantInteret;
    }

    public double getTauxInteret() {
        return tauxInteret;
    }
}
