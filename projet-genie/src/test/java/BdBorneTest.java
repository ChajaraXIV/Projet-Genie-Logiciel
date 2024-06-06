import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.m1.BdBorne;
import org.m1.BorneDeRecharge;

import java.util.List;

public class BdBorneTest {

    private BdBorne bdBorne;
    private BorneDeRecharge borne;

    @BeforeEach
    void setUp() {
        bdBorne = new BdBorne();
        borne = new BorneDeRecharge(1, "Disponible");
    }

    @Test
    void testAjouterBorne() {
        bdBorne.enregistrerBorne(borne);
        List<BorneDeRecharge> bornes = bdBorne.getBornes();
        assertTrue(bornes.contains(borne), "La borne devrait être ajoutée à la base de données.");
    }

    @Test
    void testRechercherBorne() {
        bdBorne.enregistrerBorne(borne);
        BorneDeRecharge foundBorne = bdBorne.rechercherBorne(borne.getId());
        assertEquals(borne, foundBorne, "La borne devrait être trouvée par son ID.");
    }
}