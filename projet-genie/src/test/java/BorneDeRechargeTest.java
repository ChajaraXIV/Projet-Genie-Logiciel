import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.m1.BorneDeRecharge;

public class BorneDeRechargeTest {

    private BorneDeRecharge borne;

    @BeforeEach
    void setUp() {
        borne = new BorneDeRecharge(1,"Disponible");
    }

    @Test
    void testBorneDeRechargeCreation() {
        assertEquals("B1", borne.getId());
        assertEquals("Disponible", borne.getEtat());
    }

    @Test
    void testBorneDeRechargeStatusChange() {
        borne.setEtat("Occupée");
        assertEquals("Occupée", borne.getEtat());
    }
}