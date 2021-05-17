
package se.kth.IV1350.pos.integration;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author charl
 */
public class EISHandlerTest {
    
    @Test
    public void testFindItem(){
        try {            
            String identifier = "1";
            EISHandler instance = new EISHandler();
            String expResult = "Råttfälla";
            String result = instance.findItem(identifier).getName();
            assertEquals(expResult, result);
        } 
        catch (ItemNotFoundException ex) {
            fail("Got exception itemNotFound.");
        } 
        catch (DataBaseUnacessibleException e) {
            fail("Got exception DataBaseUnacessible.");
        } 
    }
    @Test
    public void testItemNotFoundException() throws DataBaseUnacessibleException{
        String nonExistingItem = "4";
        EISHandler instance = new EISHandler();
        try {
            instance.findItem(nonExistingItem);
            fail("Exception ItemNotFound wasnt caught");

        } catch (ItemNotFoundException ex) {
            assertTrue(ex.getMessage().contains("not in the inventory"),"The exception message was wrong");

        } 
    }     
    @Test
    public void testDataBaseUnacessibleException() throws ItemNotFoundException{
        String dataBaseNotStartingIdentifier = "10";
        try {
            EISHandler instance = new EISHandler();

            instance.findItem(dataBaseNotStartingIdentifier);
            fail("Exception DataBaseUnacessible wasnt caught");

        } catch (DataBaseUnacessibleException ex) {
            assertTrue(ex.getMessage().contains("start database"),"The exception message was wrong");
        } 
    } 
    
}
