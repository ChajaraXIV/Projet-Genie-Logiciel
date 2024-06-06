package org.m1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BdVehicule {
    private List<Vehicule> vehicules;

    public BdVehicule() {
        this.vehicules = new ArrayList<>();
    }

    public List<Vehicule> getVehicules(){
        return this.vehicules;
    }

    public void ajouterVehicule(Vehicule vehicule) {
        vehicules.add(vehicule);
    }

    public void afficherVehicules() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez entrer le mot de passe : ");
        String password = scanner.nextLine();
        
        if ("admin".equals(password)) {
            System.out.println("Liste des véhicules enregistrés :");
            for (Vehicule vehicule : vehicules) {
                System.out.println("- " + vehicule.getNumeroImmatriculation());
            }
        } else {
            System.out.println("Accès refusé : mot de passe incorrect.");
        }
}


    public Vehicule trouverVehiculeParNumeroPlaque(String numeroPlaque) {
        for (Vehicule vehicule : vehicules) {
            if (vehicule.getNumeroImmatriculation().equals(numeroPlaque)) {
                return vehicule;
            }
        }
        return null;
    }
}
