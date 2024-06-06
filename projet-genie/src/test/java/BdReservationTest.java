import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.m1.BdReservation;
import org.m1.BorneDeRecharge;
import org.m1.Client;
import org.m1.Reservation;

public class BdReservationTest {

    private BdReservation bdReservation;
    private Reservation reservation;
    private Client client;
    private BorneDeRecharge borne;

    @BeforeEach
    void setUp() {
        bdReservation = new BdReservation();
        client = new Client("Jane", "Doe", "123 Main St", "0987654321", "jane.doe@example.com", "4222222222222222");
        borne = new BorneDeRecharge(2, "Disponible");
        reservation = new Reservation(client, "ABC123", "CONF12345", LocalDateTime.of(2024, 6, 7, 10, 0), LocalDateTime.of(2024, 6, 7, 11, 0), borne);
    }

    @Test
    void testAjouterReservation() {
        bdReservation.ajouterReservation(reservation);
        List<Reservation> reservations = bdReservation.getReservations();
        assertTrue(reservations.contains(reservation), "La réservation devrait être ajoutée à la base de données.");
    }

    @Test
    void testRechercherReservation() {
        bdReservation.ajouterReservation(reservation);
        Reservation foundReservation = bdReservation.trouverReservationParNumero(reservation.getNumeroReservation());
        assertEquals(reservation, foundReservation, "La réservation devrait être trouvée par son numéro de confirmation.");
    }
}