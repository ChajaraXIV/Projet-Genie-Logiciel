
import java.util.ArrayList;
import java.util.List;

public class Client {
    private String nom;
    private String prenom;
    private String adresse;
    private String numeroMobile;
    private String email;
    private String numeroCarteDebit;
    private List<Vehicule> vehicules;
    private List<String> numerosImmatriculation;

    public Client(String nom, String prenom, String adresse, String numeroMobile, String email, String numeroCarteDebit) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numeroMobile = numeroMobile;
        this.email = email;
        this.numeroCarteDebit = numeroCarteDebit;
        this.vehicules = new ArrayList<>();
        this.numerosImmatriculation = new ArrayList<>(); // Initialisation de la liste de numéros d'immatriculation
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
    }}
