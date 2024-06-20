package org.example.banque;

import java.util.List;

public class CompteEpargne extends CompteBancaire{
    private final float tauxInteret = 4f;

    public CompteEpargne() {
    }

    public CompteEpargne(double solde, Client client, List<Operation> operations) {
        super(solde, client, operations);
    }

    public void appliquerInteret(){
        double montantInteret = this.solde * (tauxInteret/100);
        operations.add(new Operation(operations.size()+1, montantInteret, TypeOperation.DEPOT));
        this.solde += montantInteret;
    }

    public float getTauxInteret() {
        return tauxInteret;
    }
}
