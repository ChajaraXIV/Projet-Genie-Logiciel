package org.m1;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Reservation {
    private String numeroPlaque;
    private String numeroReservation;
    private LocalDateTime debutReservation;
    private LocalDateTime finReservation;
    private BorneDeRecharge borne; // Référence à la borne associée à la réservation
    private Scanner scanner = new Scanner(System.in);

    public Reservation() {
    }

    public Reservation(String numeroPlaque, String numeroReservation, LocalDateTime debutReservation, LocalDateTime finReservation, BorneDeRecharge borne) {
        this.numeroPlaque = numeroPlaque;
        this.numeroReservation = numeroReservation;
        this.debutReservation = debutReservation;
        this.finReservation = finReservation;
        this.borne = borne;
    }

    public void faireUneReservation(BdBorne bdBorne, BdReservation bdReservation, BdClient bdClient, BdVehicule bdVehicule) {
        System.out.print("Entrez le numéro d'immatriculation : ");
        String numeroPlaque = scanner.nextLine();
    
        // Vérifier si le véhicule existe déjà dans la base de données
        Vehicule vehicule = bdVehicule.trouverVehiculeParNumeroPlaque(numeroPlaque);
        Client client = null;
    
        if (vehicule != null) {
            // Le véhicule existe, récupérer le client associé
            client = bdClient.trouverClientParNumeroPlaque(numeroPlaque);
        } else {
            // Le véhicule n'existe pas, demander le numéro de téléphone
            System.out.print("Numéro de plaque non reconnu. Entrez votre numéro de mobile : ");
            String numeroMobile = scanner.nextLine();
    
            // Vérifier si le client existe dans la base de données
            client = bdClient.trouverClientParNumeroMobile(numeroMobile);
    
            if (client != null) {
                // Créer une nouvelle association véhicule-client et ajouter le véhicule à la base de données
                vehicule = new Vehicule(numeroPlaque);
                client.ajouterVehicule(vehicule);
                bdVehicule.ajouterVehicule(vehicule);
            } else {
                System.out.println("Numéro de mobile non reconnu. Veuillez vous inscrire.");
                return; // Fin de la méthode si le client n'existe pas
            }
        }
    
        System.out.print("Entrez la durée prévue de recharge (en heures) : ");
        int dureeRecharge = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne
    
        // Trouver une borne disponible
        BorneDeRecharge borneDisponible = bdBorne.trouverBorneDisponible();
    
        if (borneDisponible != null) {    
            // Créer une réservation avec la borne disponible
            LocalDateTime debutReservation = LocalDateTime.now();
            LocalDateTime finReservation = debutReservation.plusHours(dureeRecharge);
            String numeroReservation = Reservation.generateNumeroReservation(); // Générer un numéro de réservation unique
            Reservation reservation = new Reservation(numeroPlaque, numeroReservation, debutReservation, finReservation, borneDisponible);
            bdReservation.ajouterReservation(reservation);
    
            System.out.println("Réservation créée : " + reservation);
    
            // Mettre à jour l'état de disponibilité de la borne
            borneDisponible.changerDisponibilite();
            System.out.println("État de disponibilité de la borne après réservation : " + borneDisponible.isDisponible());
        } else {
            // Traitement si aucune borne disponible n'a été trouvée
            System.out.println("Aucune borne de recharge disponible.");
        }
    }
    

    // Getters et Setters
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
        // Générez un numéro de réservation unique (par exemple, en concaténant la date actuelle avec un identifiant unique)
        return "RES-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "numeroPlaque='" + numeroPlaque + '\'' +
                ", numeroReservation='" + numeroReservation + '\'' +
                ", debutReservation=" + debutReservation +
                ", finReservation=" + finReservation +
                ", borne=" + borne +
                '}';
    }
}
