package org.example.banque;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("De Rives", "Geralt", null, "01 23 45 67 89");
        client.createAccount(2000, TypeCompte.COURANT);
        client.createAccount(500, TypeCompte.EPARGNE);
        client.createAccount(3000, TypeCompte.PAYANT);

        BanqueIHM.displayMainMenu(client);
    }
}
