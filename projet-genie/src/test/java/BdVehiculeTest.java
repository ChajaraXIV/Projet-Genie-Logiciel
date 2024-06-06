import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.m1.BdVehicule;
import org.m1.Vehicule;

import java.util.List;

public class BdVehiculeTest {

    private BdVehicule bdVehicule;
    private Vehicule vehicule;

    @BeforeEach
    void setUp() {
        bdVehicule = new BdVehicule();
        vehicule = new Vehicule("DEF456");
    }

    @Test
    void testAjouterVehicule() {
        bdVehicule.ajouterVehicule(vehicule);
        List<Vehicule> vehicules = bdVehicule.getVehicules();
        assertTrue(vehicules.contains(vehicule), "Le véhicule devrait être ajouté à la base de données.");
    }

    @Test
    void testRechercherVehicule() {
        bdVehicule.ajouterVehicule(vehicule);
        Vehicule foundVehicule = bdVehicule.trouverVehiculeParNumeroPlaque(vehicule.getNumeroImmatriculation());
        assertEquals(vehicule, foundVehicule, "Le véhicule devrait être trouvé par sa plaque d'immatriculation.");
    }
}