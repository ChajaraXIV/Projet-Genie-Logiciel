import java.util.List;

public class BorneDeRecharge {
    private int id;
    private boolean disponible;
    private static List<BorneDeRecharge> bornesDeRecharge;

    public BorneDeRecharge(int id, boolean disponible) {
        this.id = id;
        this.disponible = true; // Par défaut, la borne est disponible lors de sa création
    }

    public int getId() {
        return id;
    }

 
    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    public void changerDisponibilite() {
        this.disponible = !this.disponible; // Inverse l'état de disponibilité de la borne
    }
    public static BorneDeRecharge trouverBorneDisponible(List<BorneDeRecharge> bornesDeRecharge) {
        // Logique pour trouver une borne disponible en fonction du numéro de plaque ou de la réservation
        // (Cela dépend de la structure de votre système)
        // Par exemple :
        for (BorneDeRecharge borne : bornesDeRecharge) {
            if (borne.isDisponible() == true) {
                return borne;
            }
        }
        return null; // Aucune borne disponible trouvée
    }
    
    
}
