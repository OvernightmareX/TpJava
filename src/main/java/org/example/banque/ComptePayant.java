package org.example.banque;

import java.util.List;

public class ComptePayant extends CompteBancaire{
    private double coutOperation;

    public ComptePayant() {
    }

    public ComptePayant(double solde, Client client, List<Operation> operations, double coutOperation) {
        super(solde, client, operations);
        this.coutOperation = coutOperation;
    }

    public void retirerCoutOperation(){
        this.solde -= coutOperation;
    }

    public double getCoutOperation() {
        return coutOperation;
    }
}
