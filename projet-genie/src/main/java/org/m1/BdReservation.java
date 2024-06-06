package org.m1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BdReservation {
    private List<Reservation> reservations;

    public BdReservation() {
        this.reservations = new ArrayList<>();
    }

    public void afficherReservations() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez entrer le mot de passe : ");
        String password = scanner.nextLine();
        
        if ("admin".equals(password)) {
            System.out.println("Liste des réservations :");
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        } else {
            System.out.println("Accès refusé : mot de passe incorrect.");
        }
    }

    public List<Reservation> getReservations(){
        return this.reservations;
    }

    public void ajouterReservation(Reservation reserv) {
        reservations.add(reserv);
    }

    public int getSize(){
        return reservations.size();
    }

    public Reservation getReservation(int index) {
        return reservations.get(index);
    }

    public Reservation trouverReservationParNumero(String numero) {
        for (Reservation reservation : reservations) {
            if (reservation.getNumeroReservation().equals(numero)) {
                return reservation;
            }
        }
        return null; // Aucune réservation trouvée
    }
}
