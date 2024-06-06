package org.m1;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static BdClient BdClient = new BdClient();
    private static BdReservation BdReservation = new BdReservation();
    private static BdBorne BdBorne = new BdBorne();

    public static void main(String[] args) {
        afficherMenuPrincipal();
    }
     
    private static void afficherMenuPrincipal() {
        while (true) {
            System.out.println("Bienvenue dans votre application de gestion de bornes de recharge !");
            System.out.println("1. Enregistrer un nouveau client");
            System.out.println("2. Afficher les clients enregistrés");
            System.out.println("3. Faire une réservation");
            System.out.println("4. Afficher les réservations");
            System.out.println("5. Quitter");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    Client c = new Client();
                    c.enregistrerNouveauClient(BdClient);
                    break;
                case 2:
                    BdClient.afficherClients();
                    break;
                case 3:
                    Reservation r = new Reservation();
                    r.faireUneReservation(BdBorne,BdReservation);
                    break;
                case 4:
                    BdReservation.afficherReservations();
                    break;
                case 5:
                    System.out.println("Merci d'avoir utilisé notre application. Au revoir !");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez entrer un numéro valide.");
                    break;
            }
        }
    }
}