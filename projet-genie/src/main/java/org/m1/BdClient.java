package org.m1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BdClient {
    private List<Client> clients;

    public BdClient() {
        this.clients = new ArrayList<>();
    }
    
    public List<Client> getClients(){
        return clients;
    }
    public void enregistrerClient(Client client) {
        clients.add(client);
    }

    public int getSize(){
        return clients.size();
    }

    public Client getClient(int index) {
        return clients.get(index);
    }

    public void afficherClients() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez entrer le mot de passe : ");
        String password = scanner.nextLine();
        if ("admin".equals(password)) {
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
                }
                System.out.println("**************************************");        
            }
        } else {
            System.out.println("Accès refusé : mot de passe incorrect.");
        }
    }

    public Client trouverClientParNumeroPlaque(String numeroPlaque) {
        for (Client client : clients) {
            for (Vehicule vehicule : client.getVehicules()) {
                if (vehicule.getNumeroImmatriculation().equals(numeroPlaque)) {
                    return client;
                }
            }
        }
        return null; // Aucun client trouvé
    }

    public Client trouverClientParNumeroMobile(String numeroMobile) {
        for (Client client : clients) {
            if (client.getNumeroMobile().equals(numeroMobile)) {
                return client;
            }
        }
        return null; // Aucun client trouvé
    }
}
