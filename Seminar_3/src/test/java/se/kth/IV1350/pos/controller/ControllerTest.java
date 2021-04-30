package se.kth.IV1350.pos.controller;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.IV1350.pos.integration.EASHandler;
import se.kth.IV1350.pos.integration.EISHandler;


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
    public void testEnterItem() {
        itemIdentifier = "1";
        instanceToTest.enterItem(itemIdentifier);
        String printout = printoutBuffer.toString();
        String expectedOutput = "Råttfälla";
        assertTrue(printout.contains(expectedOutput),"Item wasnt entered corrcetly");
    }
    
}
