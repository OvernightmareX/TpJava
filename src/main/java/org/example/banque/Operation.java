package org.example.banque;

public class Operation {
    private int numeroOperation;
    private double montant;
    private TypeOperation statut;

    public Operation() {
    }

    public Operation(int numeroOperation, double montant, TypeOperation statut) {
        this.numeroOperation = numeroOperation;
        this.montant = montant;
        this.statut = statut;
    }

    public int getNumeroOperation() {
        return numeroOperation;
    }

    public double getMontant() {
        return montant;
    }

    public TypeOperation getStatut() {
        return statut;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "numeroOperation=" + numeroOperation +
                ", montant=" + montant +
                ", statut=" + statut +
                '}';
    }
}
