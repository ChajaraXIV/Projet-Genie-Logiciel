public class BorneDeRecharge {
    private int id;
    private boolean disponible;

    public BorneDeRecharge(int id, boolean disponible) {
        this.id = id;
        this.disponible = true;
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
}
