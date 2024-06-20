package org.example.banque;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("De Rives", "Geralt", null, "01 23 45 67 89");
        client.createAccount(TypeCompte.COURANT);
        client.createAccount(TypeCompte.EPARGNE);
        client.createAccount(TypeCompte.PAYANT);

        BanqueIHM.displayMainMenu(client);
    }
}
