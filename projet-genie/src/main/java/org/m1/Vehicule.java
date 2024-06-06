package org.m1;

import java.util.Scanner;

public class Vehicule {
    private String numeroImmatriculation;
    private Scanner scanner = new Scanner(System.in);

    public Vehicule() {
    }
    
    public Vehicule(String numeroImmatriculation) {
        this.numeroImmatriculation = numeroImmatriculation;
    }

    public String getNumeroImmatriculation() {
        return numeroImmatriculation;
    }

    public void setNumeroImmatriculation(String numeroImmatriculation) {
        this.numeroImmatriculation = numeroImmatriculation;
    }

    public void enregistrerVehicule(BdClient bdClient, BdVehicule bdVehicule) {
        System.out.print("Entrez votre numéro de mobile : ");
        String numeroMobile = scanner.nextLine();

        // Vérifier si le client existe dans la base de données
        Client client = bdClient.trouverClientParNumeroMobile(numeroMobile);

        if (client != null) {
            System.out.print("Entrez le numéro d'immatriculation : ");
            String numeroImmatriculation = scanner.nextLine();

            // Vérifier si le véhicule existe déjà dans la base de données
            Vehicule vehiculeBd = bdVehicule.trouverVehiculeParNumeroPlaque(numeroImmatriculation);
            boolean vehiculeClientExiste = client.getVehicules().stream()
                                                  .anyMatch(v -> v.getNumeroImmatriculation().equals(numeroImmatriculation));

            if (!vehiculeClientExiste) {
                Vehicule vehicule = vehiculeBd != null ? vehiculeBd : new Vehicule(numeroImmatriculation);
                client.ajouterVehicule(vehicule);

                if (vehiculeBd == null) {
                    bdVehicule.ajouterVehicule(vehicule);
                }

                System.out.println("Véhicule enregistré avec succès.");
            } else {
                System.out.println("Le véhicule existe déjà dans la liste des véhicules du client.");
            }
        } else {
            System.out.println("Numéro de mobile non reconnu. Veuillez vous inscrire.");
        }
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "numeroImmatriculation='" + numeroImmatriculation + '\'' +
                '}';
    }
}
