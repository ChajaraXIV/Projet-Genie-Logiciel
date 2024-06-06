package org.m1;
public class Vehicule {
    private String numeroImmatriculation;

    public Vehicule(String numeroImmatriculation) {
        this.numeroImmatriculation = numeroImmatriculation;
    }

    public String getNumeroImmatriculation() {
        return numeroImmatriculation;
    }

    public void setNumeroImmatriculation(String numeroImmatriculation) {
        this.numeroImmatriculation = numeroImmatriculation;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "numeroImmatriculation='" + numeroImmatriculation + '\'' +
                '}';
    }
}
