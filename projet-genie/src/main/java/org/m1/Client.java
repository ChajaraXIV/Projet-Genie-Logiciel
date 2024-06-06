package org.m1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
    private String nom, prenom, adresse, numeroMobile, email, numeroCarteDebit;
    private List<Vehicule> vehicules;
    private Scanner scanner = new Scanner(System.in);

    public Client() {    
    }
    
    public Client(String nom, String prenom, String adresse, String numeroMobile, String email, String numeroCarteDebit) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numeroMobile = numeroMobile;
        this.email = email;
        this.numeroCarteDebit = numeroCarteDebit;
        this.vehicules = new ArrayList<>();
    }

    public Boolean hasVehicule() {
        if (vehicules.size() > 0){
            return true;
        }
        return false;
    }

    public void enregistrerNouveauClient(BdClient bd) {
        String nom, prenom, adresse, email, numeroMobile, numeroCarteDebit;
        int choix, choixAutre = 0;
        System.out.println("Veuillez entrer les informations du nouveau client :");
        
        do {
            System.out.print("Nom : ");
            nom = scanner.nextLine();
            if(nom.isEmpty()) System.out.println("Erreur : Le nom ne peut pas être vide!");
        } while (nom.isEmpty());

        do {
            System.out.print("Prénom : ");
            prenom = scanner.nextLine();
            if (prenom.isEmpty()) System.out.println("Erreur : Le prénom ne peut pas être vide!");
        } while (prenom.isEmpty());

        do {
            System.out.print("Adresse : ");
            adresse = scanner.nextLine();
            if (adresse.isEmpty()) System.out.println("Erreur : L'adresse ne peut pas être vide!");
        } while (adresse.isEmpty());

        do {
            System.out.print("Adresse e-mail : ");
            email = scanner.nextLine();
            if (email.isEmpty()) {
                System.out.println("Erreur : L'adresse ne peut pas être vide!");
            } else if (!emailValid(email, bd)) {
                email = "";
            }
        } while (email.isEmpty());

        do {
            System.out.print("Numéro de téléphone : ");
            numeroMobile = scanner.nextLine();
        } while (!isValidNumber(numeroMobile,bd));

        do {
            System.out.print("Numéro de carte de débit : ");
            numeroCarteDebit = scanner.nextLine();
        } while (!isValidCB(numeroCarteDebit));  
        
        Client client = new Client(nom, prenom, adresse, numeroMobile, email, numeroCarteDebit);
        
        System.out.print("Est-ce que vous avez un véhicule ? (1.Oui / 2.Non) : ");
        do {
            choix = scanner.nextInt();
            scanner.nextLine(); 
            if (choix == 1) {
                do {
                    System.out.print("Entrez le matricule : ");
                    String matricule = scanner.nextLine();
                    client.ajouterVehicule(new Vehicule(matricule));
                    System.out.print("Est-ce que vous voulez ajouter un autre ? (1.Oui / 2.Non) : ");
                    choixAutre = scanner.nextInt();
                    scanner.nextLine();
                } while(choixAutre == 1);
            }
        } while (choix != 1 && choix != 2);

        bd.enregistrerClient(client);

        System.out.println("Le client a été enregistré avec succés.");
    }

    private boolean isValidNumber(String num, BdClient bd){
        if (num.isEmpty()) {
            System.out.println("Erreur : Le numéro de téléphone ne peut pas être vide!");
            return false;
        }  
        if (!num.startsWith("0")) {
            System.out.println("Erreur : Le numéro de téléphone doit commencer par 0!");
            return false;
        }
        if (num.length() != 10) {
            System.out.println("Erreur : Le numéro de téléphone doit avoir exactement 10 caractères!");
            return false;
        }
        if (!num.matches("\\d{10}")) {
            System.out.println("Erreur : Le numéro de téléphone doit contenir uniquement des chiffres!");
            return false;
        }
        for (int i = 0; i < bd.getSize(); i++) {
            Client client = bd.getClient(i);
            if (client.getNumeroMobile().equals(num)) {
                System.out.println("Erreur : Ce numéro existe déjà!");
                return false;
            }
        }
        return true;
    }

    private boolean isValidCB(String num){
        if (num.isEmpty()) {
            System.out.println("Erreur : Le numéro de CB ne peut pas être vide!");
            return false;
        }

        if (!num.matches("\\d{16}")) {
            System.out.println("Erreur : Le numéro de CB doit contenir uniquement des chiffres!");
            return false;
        }
        if (num.length() != 16) {
            System.out.println("Erreur : Le numéro de CB doit avoir exactement 16 caractères!");
            return false;
        }
        return true;
    }

    private boolean emailValid(String email, BdClient bd) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            System.out.println("Erreur : Le format de l'adresse e-mail n'est pas valide!");
            return false;
        }
        for (int i = 0; i < bd.getSize(); i++) {
            Client client = bd.getClient(i);
            if (client.getEmail().equals(email)) {
                System.out.println("Erreur : Cette adresse existe déjà!");
                return false;
            }
        }
        return true;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumeroMobile() {
        return numeroMobile;
    }

    public void setNumeroMobile(String numeroMobile) {
        this.numeroMobile = numeroMobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroCarteDebit() {
        return numeroCarteDebit;
    }

    public void setNumeroCarteDebit(String numeroCarteDebit) {
        this.numeroCarteDebit = numeroCarteDebit;
    }
    
    public List<Vehicule> getVehicules() {
        return vehicules;
    }
  
    public void ajouterVehicule(Vehicule vehicule) {
        this.vehicules.add(vehicule);
    }

    @Override
    public String toString() {
    	return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", numeroMobile='" + numeroMobile + '\'' +
                ", email='" + email + '\'' +
                ", numeroCarteDebit='" + numeroCarteDebit + '\'' +
                ", vehicules='" + vehicules + '\''+             
                '}';
    }
}