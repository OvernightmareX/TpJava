package org.example.banque;

import java.util.List;

public class ComptePayant extends CompteBancaire{
    private final double coutOperation = 10;

    public ComptePayant() {
    }

    public ComptePayant(double solde, Client client, List<Operation> operations) {
        super(solde, client, operations);
    }

    public void retirerCoutOperation(){
        this.solde -= coutOperation;
    }

    public double getCoutOperation() {
        return coutOperation;
    }
}
