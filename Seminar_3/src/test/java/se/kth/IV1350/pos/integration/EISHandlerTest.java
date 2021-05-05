
package se.kth.IV1350.pos.integration;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author charl
 */
public class EISHandlerTest {
    
    @Test
    public void testFindItem() {
        String identifier = "1";
        EISHandler instance = new EISHandler();
        String expResult = "Råttfälla";
        String result = instance.findItem(identifier).getName();
        assertEquals(expResult, result);
    }
    
}
