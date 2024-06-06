package org.m1;
import java.util.ArrayList;
import java.util.List;

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
