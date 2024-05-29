

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseDeDonnes {
    private List<Client> clients;

    public BaseDeDonnes() {
        this.clients = new ArrayList<>();
    }

    public List<String> enregistrerClient(Client client) {
        List<String> erreurs = new ArrayList<>();

        // Vérifier si un client avec la même adresse e-mail existe déjà
        for (Client c : clients) {
            if (c.getEmail().equals(client.getEmail())) {
                erreurs.add("Un client avec cette adresse e-mail existe déjà.");
                return erreurs;
            }
        }

        // Ajouter le client à la liste des clients
        clients.add(client);
        return erreurs;
    }
    public void afficherClients() {
        System.out.println("Liste des clients enregistrés :");
        for (Client client : clients) {
            System.out.println("Nom : " + client.getNom());
            System.out.println("Prénom : " + client.getPrenom());
            System.out.println("Adresse : " + client.getAdresse());
            System.out.println("Adresse e-mail : " + client.getEmail());
            System.out.println("Numéro de téléphone : " + client.getNumeroMobile());
            System.out.println("Numéro de carte de débit : " + client.getNumeroCarteDebit());
            System.out.println("Véhicules :");
            for (Vehicule vehicule : client.getVehicules()) {
                System.out.println("- " + vehicule.getNumeroImmatriculation());
            }        }
    }

    private boolean clientExisteDeja(String email) {
        for (Client c : clients) {
            if (c.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

}
