import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.m1.Vehicule;

public class VehiculeTest {

    private Vehicule vehicule;

    @BeforeEach
    void setUp() {
        vehicule = new Vehicule("DEF456");
    }

    @Test
    void testVehiculeCreation() {
        assertEquals("DEF456", vehicule.getNumeroImmatriculation());
    }
}