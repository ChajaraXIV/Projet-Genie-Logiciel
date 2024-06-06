import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.m1.BdClient;
import org.m1.Client;

import java.util.List;

public class BdClientTest {

    private BdClient bdClient;
    private Client client;

    @BeforeEach
    void setUp() {
        bdClient = new BdClient();
        client = new Client("Alice", "Johnson", "789 Main St", "6677889900", "alice.johnson@example.com", "4444444444444444");
    }

    @Test
    void testAjouterClient() {
        bdClient.enregistrerClient(client);
        List<Client> clients = bdClient.getClients();
        assertTrue(clients.contains(client), "Le client devrait être ajouté à la base de données.");
    }

    @Test
    void testRechercherClient() {
        bdClient.enregistrerClient(client);
        Client foundClient = bdClient.trouverClientParNumeroMobile(client.getNumeroMobile());
        assertEquals(client, foundClient, "Le client devrait être trouvé par son email.");
    }
}