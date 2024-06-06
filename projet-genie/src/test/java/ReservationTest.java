import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.m1.BorneDeRecharge;
import org.m1.Client;
import org.m1.Reservation;

import java.time.LocalDateTime;

public class ReservationTest {

    private Reservation reservation;
    private BorneDeRecharge borne;
    private Client client;

    @BeforeEach
    void setUp() {
        borne = new BorneDeRecharge(1, "Disponible");
        client = new Client();
        reservation = new Reservation(client, "ABC123", "CONF12345", LocalDateTime.of(2024, 6, 7, 10, 0), LocalDateTime.of(2024, 6, 7, 11, 0), borne);
    }

    @Test
    void testReservationCreation() {
        assertEquals("ABC123", reservation.getNumeroPlaque(), "Le numéro de plaque devrait être 'ABC123'.");
        assertEquals("CONF12345", reservation.getNumeroReservation(), "Le numéro de réservation devrait être 'CONF12345'.");
        assertEquals(LocalDateTime.of(2024, 6, 7, 10, 0), reservation.getDebutReservation(), "Le début de la réservation devrait être le 7 juin 2024 à 10h00.");
        assertEquals(LocalDateTime.of(2024, 6, 7, 11, 0), reservation.getFinReservation(), "La fin de la réservation devrait être le 7 juin 2024 à 11h00.");
        assertEquals(borne, reservation.getBorne(), "La borne associée devrait être 'B1'.");
    }

    @Test
    void testSetNumeroPlaque() {
        reservation.setNumeroPlaque("XYZ789");
        assertEquals("XYZ789", reservation.getNumeroPlaque(), "Le numéro de plaque devrait être mis à jour à 'XYZ789'.");
    }

    @Test
    void testSetNumeroReservation() {
        reservation.setNumeroReservation("CONF67890");
        assertEquals("CONF67890", reservation.getNumeroReservation(), "Le numéro de réservation devrait être mis à jour à 'CONF67890'.");
    }

    @Test
    void testSetDebutReservation() {
        LocalDateTime newDebut = LocalDateTime.of(2024, 6, 7, 12, 0);
        reservation.setDebutReservation(newDebut);
        assertEquals(newDebut, reservation.getDebutReservation(), "Le début de la réservation devrait être mis à jour.");
    }

    @Test
    void testSetFinReservation() {
        LocalDateTime newFin = LocalDateTime.of(2024, 6, 7, 13, 0);
        reservation.setFinReservation(newFin);
        assertEquals(newFin, reservation.getFinReservation(), "La fin de la réservation devrait être mis à jour.");
    }

    @Test
    void testSetBorne() {
        BorneDeRecharge newBorne = new BorneDeRecharge(2, "Disponible");
        reservation.setBorne(newBorne);
        assertEquals(newBorne, reservation.getBorne(), "La borne associée devrait être mise à jour.");
    }

    @Test
    void testGenerateNumeroReservation() {
        String numeroReservation = Reservation.generateNumeroReservation();
        assertTrue(numeroReservation.startsWith("RES-"), "Le numéro de réservation devrait commencer par 'RES-'.");
        assertEquals(18, numeroReservation.length(), "Le numéro de réservation devrait avoir une longueur de 20 caractères.");
    }

}