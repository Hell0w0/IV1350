/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
}
