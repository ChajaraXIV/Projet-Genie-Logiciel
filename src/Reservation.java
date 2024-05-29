import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private String numeroPlaque;
    private String numeroReservation;
    private LocalDateTime debutReservation;
    private LocalDateTime finReservation;
    private BorneDeRecharge borne; // Référence à la borne associée à la réservation

    public Reservation(String numeroPlaque, String numeroReservation, LocalDateTime debutReservation, LocalDateTime finReservation, BorneDeRecharge borne) {
        this.numeroPlaque = numeroPlaque;
        this.numeroReservation = numeroReservation;
        this.debutReservation = debutReservation;
        this.finReservation = finReservation;
        this.borne = borne;
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
