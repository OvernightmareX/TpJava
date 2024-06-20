package org.example.banque;

import java.util.List;

public class CompteCourant extends CompteBancaire{

    public CompteCourant() {
    }

    public CompteCourant(double solde, Client client, List<Operation> operations) {
        super(solde, client, operations);
    }
}
