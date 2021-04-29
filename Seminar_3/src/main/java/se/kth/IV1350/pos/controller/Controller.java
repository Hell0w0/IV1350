package se.kth.IV1350.seminar_3.controller;

import se.kth.IV1350.seminar_3.integration.CashRegister;
import se.kth.IV1350.seminar_3.integration.EASHandler;
import se.kth.IV1350.seminar_3.integration.EISHandler;
import se.kth.IV1350.seminar_3.integration.ReceiptPrinter;
import se.kth.IV1350.seminar_3.model.Sale;

/**
 * This is the applications only controller.
 * All calls passing to the model goes through this class
 * @author charl
 */
public class Controller {
    private EISHandler eis;
    private EASHandler eas;
    
    private Sale sale;
    private CashRegister cashRegister;
  
    /**
     * Starts a new sale. This method msut be called before anything else is done during a sale.
     * 
     */
    public void startSale(){
        sale = new Sale();
    }
    /**
     * 
     * @param eis handler for all calls to External Inventory System.
     * @param eas handler for all calls to External Accounting System.
     * cashRegister generates a new instance of a register.
     */
    public Controller(EISHandler eis,EASHandler eas){
        this.eis = eis;
        this.eas = eas;
        
        this.cashRegister = new CashRegister();
        
        System.out.println("Controller was started successfully!");
    }
    
}
