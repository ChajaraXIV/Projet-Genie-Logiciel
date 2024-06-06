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

    public void faireUneReservation(BdBorne bdBorne, BdReservation bdReservation) {
        System.out.print("Entrez le numéro d'immatriculation : ");
        String numeroPlaqueOuReservation = scanner.nextLine();

        // Trouver une borne disponible
        BorneDeRecharge borneDisponible = bdBorne.trouverBorneDisponible();

        if (borneDisponible != null) {
            // Traitement si une borne disponible a été trouvée
            System.out.println("Une borne de recharge est disponible : " + borneDisponible.getId());

            // Créer une réservation avec la borne disponible
            LocalDateTime debutReservation = LocalDateTime.now();
            LocalDateTime finReservation = debutReservation.plusHours(1); // Par exemple, une réservation d'une heure
            String numeroReservation = Reservation.generateNumeroReservation(); // Générer un numéro de réservation unique
            Reservation reservation = new Reservation(numeroPlaqueOuReservation, numeroReservation, debutReservation, finReservation, borneDisponible);
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
