package org.m1;

import java.util.ArrayList;
import java.util.List;

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

    public Vehicule trouverVehiculeParNumeroPlaque(String numeroPlaque) {
        for (Vehicule vehicule : vehicules) {
            if (vehicule.getNumeroImmatriculation().equals(numeroPlaque)) {
                return vehicule;
            }
        }
        return null;
    }
}
