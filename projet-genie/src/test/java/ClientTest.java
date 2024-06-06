import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.m1.Client;
import org.m1.Vehicule;

public class ClientTest {

    private Client client;

    @BeforeEach
    void setUp() {
        client = new Client("John", "Doe", "123 Main St", "1234567890", "john.doe@example.com", "4111111111111111");
    }

    @Test
    void testClientCreation() {
        assertEquals("John", client.getNom());
        assertEquals("Doe", client.getPrenom());
        assertEquals("123 Main St", client.getAdresse());
        assertEquals("1234567890", client.getNumeroMobile());
        assertEquals("john.doe@example.com", client.getEmail());
        assertEquals("4111111111111111", client.getNumeroCarteDebit());
    }

    @Test
    void testAjouterVehicule() {
        Vehicule vehicule = new Vehicule("ABC123");
        client.ajouterVehicule(vehicule);
        assertTrue(client.getVehicules().contains(vehicule), "Le véhicule devrait être ajouté à la liste des véhicules du client.");
        assertEquals("ABC123", client.getVehicules().get(0).getNumeroImmatriculation(), "La plaque d'immatriculation du véhicule ajouté devrait être 'ABC123'.");
    }
}