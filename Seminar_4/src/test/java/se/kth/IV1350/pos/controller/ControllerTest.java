package se.kth.IV1350.pos.controller;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.IV1350.pos.DTO.SaleInformationDTO;
import se.kth.IV1350.pos.integration.EASHandler;
import se.kth.IV1350.pos.integration.EISHandler;
import se.kth.IV1350.pos.integration.DataBaseUnacessibleException;
import se.kth.IV1350.pos.integration.ItemNotFoundException;


/**
 *
 * @author charl
 */
public class ControllerTest {
    private Controller instanceToTest;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;
    private String itemIdentifier;
    private EISHandler eis;
    private EASHandler eas;
    
    @BeforeEach
    public void setUp() {        
        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
        
        
        eas = new EASHandler();
        eis = new EISHandler();
        instanceToTest = new Controller(eis,eas);

    }
    
    @AfterEach
    public void tearDown() {
        instanceToTest =null;
        printoutBuffer = null;
        System.setOut(originalSysOut);
    }

    @Test
    public void testCashRegisterCreation() {
        String printout = printoutBuffer.toString();
        String expectedOutput = "successfully";
        assertTrue(printout.contains(expectedOutput),"UI did not start correctly");
    }
    @Test
    public void testEnterSingleItem(){
   
    
    
        try{
            instanceToTest.startSale();
            String identifier = "1";
            String name = instanceToTest.enterItem(identifier).getCurrentItemName();
            assertEquals("Råttfälla", name,"Enter item is not working,expected Name didnt match with identifers name.");
        }
        catch(ItemNotFoundException e){
            fail("Got exception ItemNotFound");
        }
        catch(DataBaseUnacessibleException ex){
            fail("Got exception ItemNotFound");
        }
        
    }

    @Test
    public void testChangeWithOneItem(){
        
    
        try{
            instanceToTest.startSale();
            instanceToTest.enterItem("1");
            double change = instanceToTest.pay(70,"kr");
            assertEquals(7.28, change,0.01,"Calculate change isnt working correctly");  
        }
        catch(ItemNotFoundException e){
            fail("Got exception ItemNotFound");
        }
        catch(DataBaseUnacessibleException ex){
            fail("Got exception ItemNotFound");
        }
        
    }    
    @Test
    public void testRegisterUpdating() {
        try{
            instanceToTest.startSale();
            instanceToTest.enterItem("1");
            instanceToTest.pay(70,"kr");
            double registerAmount = instanceToTest.cashRegister.getAmountInRegister();
            assertEquals(1062.72, registerAmount,0.001,"Update Register amount isnt working correctly");
        }
        catch(ItemNotFoundException e){
            fail("Got exception ItemNotFound");
        }
        catch(DataBaseUnacessibleException ex){
            fail("Got exception ItemNotFound");
        }
        
    }    
    @Test
    public void testReceipt(){
        try{
            instanceToTest.startSale();
            instanceToTest.enterItem("1");
            instanceToTest.enterItem("1");
            instanceToTest.enterItem("2");
            instanceToTest.pay(140,"kr");
            String receiptString = instanceToTest.completeSale();
            String expectedOutput = "ICA,Ringvägen 1, 666 42\nItems: \nRåttfälla 2 112.0 kr\nSko 1 2.0 kr\nTotal: 127.68 kr\nVAT: 13.68 kr\nAmount paid: 140 kr";
            assertEquals(expectedOutput,receiptString,"Print receipt isnt working correctly");
        }
        catch(ItemNotFoundException e){
            fail("Got exception ItemNotFound");
        }
        catch(DataBaseUnacessibleException ex){
            fail("Got exception ItemNotFound");
        }

    } 

}