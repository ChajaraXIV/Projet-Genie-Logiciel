package org.m1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Reservation {
    private Client client;
    private String numeroPlaque;
    private String numeroReservation;
    private LocalDateTime debutReservation;
    private LocalDateTime finReservation;
    private BorneDeRecharge borne; // Référence à la borne associée à la réservation
    private Scanner scanner = new Scanner(System.in);

    public Reservation() {
    }

    public Reservation(Client client, String numeroPlaque, String numeroReservation, LocalDateTime debutReservation, LocalDateTime finReservation, BorneDeRecharge borne) {
        this.client = client;
        this.numeroPlaque = numeroPlaque;
        this.numeroReservation = numeroReservation;
        this.debutReservation = debutReservation;
        this.finReservation = finReservation;
        this.borne = borne;
    }

    public void faireUneReservation(BdBorne bdBorne, BdReservation bdReservation, BdClient bdClient, BdVehicule bdVehicule) {
        System.out.print("Entrez le numéro d'immatriculation : ");
        String numeroPlaque = scanner.nextLine();
    
        Vehicule vehicule = bdVehicule.trouverVehiculeParNumeroPlaque(numeroPlaque);
        Client client = null;
    
        if (vehicule != null) {
            client = bdClient.trouverClientParNumeroPlaque(numeroPlaque);
        } else {
            System.out.print("Numéro de plaque non reconnu. Entrez votre numéro de mobile : ");
            String numeroMobile = scanner.nextLine();
    
            client = bdClient.trouverClientParNumeroMobile(numeroMobile);
    
            if (client != null) {
                vehicule = new Vehicule(numeroPlaque);
                client.ajouterVehicule(vehicule);
                bdVehicule.ajouterVehicule(vehicule);
            } else {
                System.out.println("Numéro de mobile non reconnu. Veuillez vous inscrire.");
                return;
            }
        }
    
        System.out.print("Entrez la durée prévue de recharge (en heures) : ");
        int dureeRecharge = scanner.nextInt();
        scanner.nextLine();
    
        BorneDeRecharge borneDisponible = bdBorne.trouverBorneDisponible();
    
        if (borneDisponible != null) {    
            LocalDateTime debutReservation = LocalDateTime.now();
            LocalDateTime finReservation = debutReservation.plusHours(dureeRecharge);
            String numeroReservation = Reservation.generateNumeroReservation();
            Reservation reservation = new Reservation(client, numeroPlaque, numeroReservation, debutReservation, finReservation, borneDisponible);
            bdReservation.ajouterReservation(reservation);
    
            System.out.println("Réservation créée : " + reservation);
    
            borneDisponible.setEtat("réservée");
        } else {
            System.out.println("Aucune borne de recharge disponible.");
        }
    }

    // Getters et Setters
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getNumeroPlaque() {
        return numeroPlaque;
    }

    public void setNumeroPlaque(String numeroPlaque) {
        this.numeroPlaque = numeroPlaque;
    }

    public String getNumeroReservation() {
        return numeroReservation;
    }

    public void setNumeroReservation(String numeroReservation) {
        this.numeroReservation = numeroReservation;
    }

    public LocalDateTime getDebutReservation() {
        return debutReservation;
    }

    public void setDebutReservation(LocalDateTime debutReservation) {
        this.debutReservation = debutReservation;
    }

    public LocalDateTime getFinReservation() {
        return finReservation;
    }

    public void setFinReservation(LocalDateTime finReservation) {
        this.finReservation = finReservation;
    }

    public BorneDeRecharge getBorne() {
        return borne;
    }

    public void setBorne(BorneDeRecharge borne) {
        this.borne = borne;
    }

    public static String generateNumeroReservation() {
        return "RES-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "client=" + client +
                ", numeroPlaque='" + numeroPlaque + '\'' +
                ", numeroReservation='" + numeroReservation + '\'' +
                ", debutReservation=" + debutReservation +
                ", finReservation=" + finReservation +
                ", borne=" + borne +
                '}';
    }
}