package se.kth.IV1350.seminar_3.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import se.kth.IV1350.seminar_3.controller.Controller;
import se.kth.IV1350.seminar_3.integration.EASHandler;
import se.kth.IV1350.seminar_3.integration.EISHandler;

/**
 *
 * @author charl
 */
public class ViewTest {
    private View instanceToTest;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;
    
    private EISHandler eis;
    private EASHandler eas;
    @BeforeEach
    public void setUp(){
      
        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
        
        eis = new EISHandler();
        eas = new EASHandler();
        Controller contr = new Controller(eis,eas);
        instanceToTest = new View(contr);
    }
    @AfterEach
    public void tearDown(){
        instanceToTest = null;
        
        printoutBuffer = null;
        System.setOut(originalSysOut);
    }
    @Test
    public void testRunFakeExe() {
       instanceToTest.runFakeExe();
       String printout = printoutBuffer.toString();
       String expectedOutput = "started";
       assertTrue(printout.contains(expectedOutput),"UI did not start correctly");
    } 
}
