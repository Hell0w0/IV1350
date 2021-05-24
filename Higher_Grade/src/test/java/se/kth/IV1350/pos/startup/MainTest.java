package se.kth.IV1350.pos.startup;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import se.kth.IV1350.pos.integration.DataBaseUnacessibleException;
import se.kth.IV1350.pos.integration.ItemNotFoundException;


/**
 *
 * @author charl
 */
public class MainTest {
    private Main instanceToTest;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;
    @BeforeEach
    public void setUp(){
        instanceToTest = new Main();
        
        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
    }
    @AfterEach
    public void tearDown(){
        instanceToTest = null;
        
        printoutBuffer = null;
        System.setOut(originalSysOut);
    }
    @Test
    public void testUIHasStarted() throws ItemNotFoundException, DataBaseUnacessibleException {
        String[] args = null;
        Main.main(args);
        String printout = printoutBuffer.toString();
        String expectedOutput = "started";
        assertTrue(printout.contains(expectedOutput),"UI did not start correctly");
   
    }
    
}