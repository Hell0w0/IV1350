
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
            fail("Got exception.");
        } 
        catch (DataBaseUnacessibleException e) {
            fail("Got exception.");
        } 
    }
    @Test
    public void testItemNotFoundException() throws ItemNotFoundException, DataBaseUnacessibleException{
        String nonExistingItem = "4";
        EISHandler instance = new EISHandler();
        try {
            instance.findItem(nonExistingItem);
        } catch (ItemNotFoundException ex) {
            fail("Got exception ItemNotFound");
        } 
    }     
    @Test
    public void testDataBaseUnacessibleException() throws DataBaseUnacessibleException, ItemNotFoundException {
        String dataBaseNotStartingIdentifier = "10";
        try {
            EISHandler instance = new EISHandler();

            instance.findItem(dataBaseNotStartingIdentifier);
        } catch (DataBaseUnacessibleException ex) {
            fail("Got exception DataBaseUnacessible.");
        } 
    } 
    
}
