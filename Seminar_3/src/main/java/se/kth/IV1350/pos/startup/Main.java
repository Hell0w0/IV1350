package se.kth.IV1350.seminar_3.startup;

import se.kth.IV1350.seminar_3.controller.Controller;
import se.kth.IV1350.seminar_3.integration.EASHandler;
import se.kth.IV1350.seminar_3.integration.EISHandler;
import se.kth.IV1350.seminar_3.integration.ReceiptPrinter;
import se.kth.IV1350.seminar_3.view.View;

/**
 * This is the start sequence of the entire application.
 * @author charl
 */
public class Main {
    /**
     * The main method starts the entire application
     * @param args 
     */
    public static void main(String[] args){
        EASHandler eas = new EASHandler();
        EISHandler eis = new EISHandler();
        ReceiptPrinter printer = new ReceiptPrinter();
        Controller contr = new Controller(eis,eas);
        View view = new View(contr);
        view.runFakeExe();
    }
}
