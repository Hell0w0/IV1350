package se.kth.IV1350.pos.controller;

import se.kth.IV1350.pos.DTO.ItemDTO;
import se.kth.IV1350.pos.DTO.PaymentDTO;
import se.kth.IV1350.pos.DTO.SaleDTO;
import se.kth.IV1350.pos.DTO.SaleInformationDTO;
import se.kth.IV1350.pos.integration.CashRegister;
import se.kth.IV1350.pos.integration.EASHandler;
import se.kth.IV1350.pos.integration.EISHandler;
import se.kth.IV1350.pos.model.Sale;


/**
 * This is the applications only controller.
 * All calls passing to the model goes through this class
 * saleDTO refers to the collection of data from the completed sale.
 * paymentDTO refers to the collection of data from the payment.
 * @author charl
 */
public class Controller {
    
    private EISHandler eis;
    private EASHandler eas;
    
    private SaleDTO saleDTO;
    private PaymentDTO paymentDTO;
    
    private Sale sale;
    CashRegister cashRegister;
  
    /**
     * Starts a new sale. This method must be called before anything else is done during a sale.
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
    /**
     * A function that enters the items identifer into the External Inventory Database and adds the item and its information 
     * to the current sale.
     * @param itemIdentifier refers to the identifier on the item.
     * @return the saleInfrmoation for that specific item and the current total to the cashier. 
     */
    public SaleInformationDTO enterItem(String itemIdentifier){
            ItemDTO item = eis.findItem(itemIdentifier);
            SaleInformationDTO saleInformation = sale.addItem(item);
            System.out.println(saleInformation.getCurrentItemName());
            return saleInformation;
    }
    /**
     * A function that handles the customer paying for thier purchase with cash.
     * Change is calculated from the amount the customer paid with the total pice of the purchase subtacted from it.
     * CashRegister is updated with the new amount paid.
     * @param amountPaid amount of money in cash paid by the customer
     * @param currency the currency of the cash paid by the customer.
     * @return the change left over from the purchase.
     */
    public double pay(double amountPaid,String currency){
        
        saleDTO = sale.createSaleDTO();
        paymentDTO = new PaymentDTO(amountPaid,currency);
        double change = paymentDTO.getAmountPaid() - saleDTO.getTotalPrice();

        cashRegister.updateAmountInRegister(amountPaid - change);

        return change;

    }
    /**
     * The function completes the sale by updating the external systems and printing a receipt to the customer.
     * @return a receipt with the information of the current sale.
     */
    public String completeSale(){
        updateEISAndEAS();
        return printReceipt();
    }
    /**
    * The function updates the External inventory and External accounting System with the Sale and payment informaiton accordingly.
     * @param saleDTO a class holding the information about the sale
     * @param paymentDTO a class holding the information about the payment.
     */
    private void updateEISAndEAS(){
        eas.registerPayment(paymentDTO);
        eis.updateInventory(saleDTO);
    }
    /**
     * The function prints a receipt of the current sale.
     * @return a String of the receipt.
     */
    public String printReceipt(){
        return sale.getReceiptSummary(saleDTO, paymentDTO);

    }
}
    
