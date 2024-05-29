import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    private static Scanner scanner = new Scanner(System.in);
    private static BaseDeDonnes baseDonnees = new BaseDeDonnes();
    private static List<BorneDeRecharge> bornesDeRecharge = new ArrayList<>(); // Liste de bornes de recharge
    private static List<Reservation> reservations = new ArrayList<>(); // Liste de réservations

    public static void main(String[] args) {
        // Initialisez vos bornes de recharge ici
        initialiserBornesDeRecharge();
        afficherMenuPrincipal();
    }

    private static void initialiserBornesDeRecharge() {
        // Créez et ajoutez vos bornes de recharge à la liste ici
        BorneDeRecharge borne1 = new BorneDeRecharge(1, true);
        BorneDeRecharge borne2 = new BorneDeRecharge(2, true);
        BorneDeRecharge borne3 = new BorneDeRecharge(3, true);
        BorneDeRecharge borne4 = new BorneDeRecharge(4, true);
        bornesDeRecharge.add(borne1);
        bornesDeRecharge.add(borne2);
        bornesDeRecharge.add(borne3);
        bornesDeRecharge.add(borne4);
    }
    
    private static void afficherClients() {
        baseDonnees.afficherClients();
        afficherMenuPrincipal();
    }
    
    private static void afficherReservations() {
        System.out.println("Liste des réservations :");
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
        afficherMenuPrincipal();
        
    } 
    private static boolean isValidEmailAddress(String email) {
        // Utiliser une expression régulière pour vérifier le format de l'adresse e-mail
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    private static void ajouterReservation(Reservation reservation) {
        // Ajouter la réservation à la liste de réservations
        reservations.add(reservation);
    }
     
    private static void afficherMenuPrincipal() {
        System.out.println("Bienvenue dans votre application de gestion de bornes de recharge !");
        System.out.println("1. Enregistrer un nouveau client");
        System.out.println("2. Afficher les clients enregistrés");
        System.out.println("3. Quitter");
        System.out.println("4. Faire une résérvation");
        System.out.println("5. Afficher les résérvations");



        int choix = scanner.nextInt();
        scanner.nextLine(); // Pour consommer le retour à la ligne

        switch (choix) {
            case 1:
                enregistrerNouveauClient();
                break;
            case 2:
                afficherClients();
            case 3:
                System.out.println("Merci d'avoir utilisé notre application. Au revoir !");
                System.exit(0);
            case 4:
            	FaireUneReservation();
            case 5:
            	afficherReservations();
            	default:
                System.out.println("Choix invalide. Veuillez entrer un numéro valide.");
                afficherMenuPrincipal();
        }
    }

    private static void enregistrerNouveauClient() {
        System.out.println("Veuillez entrer les informations du nouveau client :");
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        if (nom.isEmpty()) {
            System.out.println("Erreur : Le nom ne peut pas être vide.");
            enregistrerNouveauClient(); // Demander à nouveau le nom
            return;
        }
        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();
        if (prenom.isEmpty()) {
            System.out.println("Erreur : Le prénom ne peut pas être vide.");
            enregistrerNouveauClient(); // Demander à nouveau le prénom
            return;
        }
        System.out.print("Adresse : ");
        String adresse = scanner.nextLine();
        if (adresse.isEmpty()) {
            System.out.println("Erreur : L'adresse ne peut pas être vide.");
            enregistrerNouveauClient(); // Demander à nouveau l'adresse
            return;
        }
        String email;
        do {
            System.out.print("Adresse e-mail : ");
            email = scanner.nextLine();
            if (!isValidEmailAddress(email)) {
                System.out.println("Erreur : Le format de l'adresse e-mail n'est pas valide.");
            }
        } while (!isValidEmailAddress(email));

        String numeroMobile;
        do {
            System.out.print("Numéro de téléphone : ");
            numeroMobile = scanner.nextLine();
            if (numeroMobile.length() != 10) {
                System.out.println("Erreur : Le numéro de téléphone doit avoir exactement 10 caractères.");
            }
        } while (numeroMobile.length() != 10);
        System.out.print("Numéro de carte de débit : ");
        String numeroCarteDebit = scanner.nextLine();
        System.out.print("Est-ce que vous avez un véhicule ? (1.Oui / 2.Non) : ");
        int choix = scanner.nextInt();
        scanner.nextLine(); // Consomme la nouvelle ligne

        Client client = new Client(nom, prenom, adresse, numeroMobile, email, numeroCarteDebit); // Créer un nouveau client avec les informations saisies
        if (choix == 1) {
            System.out.print("Entrez le matricule : ");
            String matricule = scanner.nextLine();
            client.ajouterVehicule(new Vehicule(matricule));
            System.out.print(client); 

            // Faites quelque chose avec le matricule...
        } else {
             System.out.print("");
        }
        System.out.print("Le client a été enregistré avec succes ");

        // Créer un nouveau client avec les informations saisies

        // Enregistrer le client dans la base de données
        List<String> erreurs = baseDonnees.enregistrerClient(client);

     // Afficher les erreurs s'il y en a
     if (!erreurs.isEmpty()) {
         System.out.println("Erreur(s) lors de l'enregistrement du client :");
         for (String erreur : erreurs) {
             System.out.println("- " + erreur);
         }
     }
     // Retourner au menu principal
        afficherMenuPrincipal();
    }
    private static void FaireUneReservation(){
        // Création d'une liste de bornes de recharge
     
        
        System.out.print("Entrez le numéro d'immatriculation : ");
        String numeroPlaqueOuReservation = scanner.nextLine();

        // Trouver une borne disponible
        BorneDeRecharge borneDisponible = BorneDeRecharge.trouverBorneDisponible(bornesDeRecharge);

        if (borneDisponible != null) {
            // Traitement si une borne disponible a été trouvée
            System.out.println("Une borne de recharge est disponible : " + borneDisponible.getId());

            // Créer une réservation avec la borne disponible
            LocalDateTime debutReservation = LocalDateTime.now();
            LocalDateTime finReservation = debutReservation.plusHours(1); // Par exemple, une réservation d'une heure
            String numeroReservation = Reservation.generateNumeroReservation(); // Générer un numéro de réservation unique
            Reservation reservation = new Reservation(numeroPlaqueOuReservation, numeroReservation, debutReservation, finReservation, borneDisponible);
            ajouterReservation(reservation);
            
            System.out.println("Réservation créée : " + reservation);
            
            // Mettre à jour l'état de disponibilité de la borne
            borneDisponible.changerDisponibilite();
            System.out.print("État de disponibilité de la borne après réservation : " + borneDisponible.isDisponible());
        } else {
            // Traitement si aucune borne disponible n'a été trouvée
            System.out.println("Aucune borne de recharge disponible.");
        }

        // Afficher le menu principal
        afficherMenuPrincipal();
    }
 



    
}
