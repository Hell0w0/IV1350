package se.kth.IV1350.pos.startup;

import se.kth.IV1350.pos.controller.Controller;
import se.kth.IV1350.pos.integration.DCHandler;
import se.kth.IV1350.pos.integration.DataBaseUnacessibleException;
import se.kth.IV1350.pos.integration.EASHandler;
import se.kth.IV1350.pos.integration.EISHandler;
import se.kth.IV1350.pos.integration.ReceiptPrinter;
import se.kth.IV1350.pos.integration.ItemNotFoundException;
import se.kth.IV1350.pos.view.View;

/**
 * This is the start sequence of the entire application.
 * @author charl
 */
public class Main {
    /**
     * The main method starts the entire application
     * @param args 
     */
    public static void main(String[] args) throws ItemNotFoundException, DataBaseUnacessibleException{
        EASHandler eas = new EASHandler();
        EISHandler eis = new EISHandler();
        ReceiptPrinter printer = new ReceiptPrinter();
        DCHandler dc = new DCHandler();
        Controller contr = new Controller(eis,eas,dc);
        View view = new View(contr);
        view.runFakeExe();
    }
}
