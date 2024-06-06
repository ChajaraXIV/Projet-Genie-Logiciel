import java.util.ArrayList;
import java.util.List;

public class BdReservation {
    private List<Reservation> reservations;

    public BdReservation() {
        this.reservations = new ArrayList<>();
    }

    public void afficherReservations() {
        System.out.println("Liste des réservations :");
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
        
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
}
