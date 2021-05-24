package se.kth.IV1350.pos.model;

import java.time.LocalTime;
import java.util.ArrayList;
import se.kth.IV1350.pos.DTO.PaymentDTO;
import se.kth.IV1350.pos.DTO.SaleDTO;
import se.kth.IV1350.pos.integration.ReceiptPrinter;

/**
 * Represents one sale.
 * @author charl
 */
public class Receipt {
    private LocalTime saleTime;
    private ArrayList <Item> items; 
    private double totalPrice;
    private double totalVAT;
    private double amountPaid;
    private String currency;
    private String storeInformation;
    private ReceiptPrinter printer;
    /**
     * Creates the constructor for a receipt.
     * @param saleDTO a object of SaleDTO holding the informaiton about a Sale.
     * @param paymentDTO a object of PaymentDTO holding the information about the payment of the sale.
     */
    public Receipt(SaleDTO saleDTO, PaymentDTO paymentDTO){
        this.saleTime=saleDTO.getSaleTime();
        this.items=saleDTO.getItems();
        this.totalPrice=saleDTO.getTotalPrice();
        this.currency=paymentDTO.getCurrency();
        this.amountPaid=paymentDTO.getAmountPaid();
        this.totalVAT=saleDTO.getTotalVAT();
        this.storeInformation="ICA,Ringvägen 1, 666 42";
        this.printer=new ReceiptPrinter();
    }   
    /**
     * This function send the receipt information to the printer.
     */
    public void sendReceiptToPrinter(){   
         printer.printReceiptToCustomer(this);
    } 
    /**
     * returns the store informaiton, like address and name
     * @return the store infromation
     */
    public String getStoreInformation(){
        return storeInformation;
    }
    /**
     * Creates a receipt of some of its contents.
     * @return a summary of the items bought and amount paid.
     */
    public String getReceiptSummary(){
        StringBuilder sb = new StringBuilder();
        for(Item item:items){
            sb.append(item.getName()+" "+item.getQuantity()+" "+item.getPrice()*item.getQuantity()+" kr"+"\n");
        }
        return storeInformation+"\n"+"Items: \n"+sb.toString()+"Total: "+totalPrice+" kr\n"+"VAT: "+totalVAT+" kr\n"+"Amount paid: "+(int)amountPaid+" "+currency;
    }
}
