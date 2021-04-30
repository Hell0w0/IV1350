package se.kth.IV1350.pos.controller;

import se.kth.IV1350.pos.DTO.ItemDTO;
import se.kth.IV1350.pos.DTO.PaymentDTO;
import se.kth.IV1350.pos.DTO.SaleDTO;
import se.kth.IV1350.pos.DTO.SaleInformationDTO;
import se.kth.IV1350.pos.integration.CashRegister;
import se.kth.IV1350.pos.integration.EASHandler;
import se.kth.IV1350.pos.integration.EISHandler;
import se.kth.IV1350.pos.model.Receipt;
import se.kth.IV1350.pos.model.Sale;


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
    
    public SaleInformationDTO enterItem(String itemIdentifier){
            ItemDTO item = eis.findItem(itemIdentifier);
            SaleInformationDTO saleInformation = sale.addItem(item);
            System.out.println(saleInformation.getCurrentItemName());
            return saleInformation;
    }
    public double pay(double amountPaid,String currency){
        
        SaleDTO saleDTO = sale.createSaleDTO();
        PaymentDTO paymentDTO = new PaymentDTO(amountPaid,currency);
        double change = paymentDTO.getAmountPaid() - saleDTO.getTotalPrice();

        cashRegister.updateAmountInRegister(amountPaid - change);

        updateEISAndEASAndPrintReceipt(saleDTO,paymentDTO);

        return change;

    }
    public void updateEISAndEASAndPrintReceipt(SaleDTO saleDTO,PaymentDTO paymentDTO){
        eas.registerPayment(paymentDTO);
        eis.updateInventory(saleDTO);
        sale.createAndPrintReceipt(saleDTO,paymentDTO);
    }
}
    
